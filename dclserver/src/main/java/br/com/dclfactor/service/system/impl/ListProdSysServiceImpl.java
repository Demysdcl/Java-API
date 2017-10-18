/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.enumeration.StatusEnum;
import br.com.dclfactor.models.ListProdResponse;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcListProduction;
import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.models.alcatel.AlcOrder;
import br.com.dclfactor.models.gbr.GbrListPack;
import br.com.dclfactor.repositories.ListPackRepository;
import br.com.dclfactor.repositories.ListProdRepository;
import br.com.dclfactor.repositories.LotRepository;
import br.com.dclfactor.repositories.OrderRepository;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.service.response.LotResponse;
import br.com.dclfactor.service.sync.PrintLabelService;
import br.com.dclfactor.service.system.ListProdSysService;
import br.com.dclfactor.utils.ZPLPrintUtil;
import br.com.dclfactor.utils.ZPLString;
import io.reactivex.Single;
import static io.reactivex.Single.*;
import java.util.Date;
import javax.print.PrintService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("listProdSysService")
public class ListProdSysServiceImpl extends GenericSystemServiceImpl<AlcListProduction, Integer>
        implements ListProdSysService {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private ListProdRepository repository;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private OrderRepository poRepository;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private LotRepository lotRepository;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private LotSysServiceImpl lotService;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private ListPackRepository packRepository;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private PrintLabelService plService;

    @Override
    protected String getDescription() {
        return "Lots Production";
    }

    @Override
    public Single<SystemWrapper<ListProdResponse>> processProduction(String lotId, String box) {
        return defer(() -> {
            AlcLot lot = lotRepository.findOne(lotId);
            AlcListProduction prod = new AlcListProduction(box, lot);
            return noValidBox(box, prod).flatMap((SystemWrapper<ListProdResponse> result) -> {
                ListProdResponse resp = result.getValue();
                if (!resp.isValidBox() || resp.isProccessed()) {
                    return just(result);
                } else {
                    AlcListProduction newProd = saveProcessing(prod);
                    resp.setResponse(new LotResponse(newProd.getLote()));
                    resp.setFinishedLot(!newProd.getLote().getId().equals(lotId)
                            || newProd.getLote().getStatus().equals(StatusEnum.FINALIZADO));
                    resp.setFinishedPO(newProd.getOp().getStatus().equals(StatusEnum.FINALIZADO));
                    resp.setValidBox(true);
                    resp.setProccessed(false);
                    return just(SystemWrapper.wrapper(getDescription(), resp));
                }
            });
        });
    }

    private AlcListProduction saveProcessing(AlcListProduction prod) {
        AlcListProduction alp = prod;
        AlcOrder po = alp.getOp();
        AlcLot lotResult = saveProcessingLot(alp.getLote());
        po = poRepository.findOne(po.getId());
        po.setProdQty(po.getProdQty() + po.getSku().getQtdProdutoColetivo());
        if(po.getDtStart() == null){
            po.setDtStart(new Date());
        }
        if (po.getQuantity() <= po.getProdQty()) {
            if (lotResult.getDtFinish() == null) {
                lotResult.setDtFinish(new Date());
                lotResult.setStatus(StatusEnum.FINALIZADO);
                lotResult = lotRepository.save(lotResult);
                print(lotResult);
            }
            po.setStatus(StatusEnum.FINALIZADO);
            po.setDtEnd(new Date());
        } else if (lotResult.getStatus().equals(StatusEnum.FINALIZADO)) {
            print(lotResult);
            lotResult = lotService.getLoteByOrder(po.getId()).blockingGet().getValue();
        }

        po = poRepository.save(po);
        alp.setOp(po);
        repository.save(alp);
        alp.setLote(lotResult);
        return alp;
    }

    private AlcLot saveProcessingLot(AlcLot lot) {
        lot = lotRepository.findOne(lot.getId());
        lot.setQtyProd(lot.getQtyProd() + 1);
        if (lot.getQuantity() <= lot.getQtyProd()) {
            lot.setStatus(StatusEnum.FINALIZADO);
            lot.setDtFinish(new Date());
        }
        return lotRepository.save(lot);
    }

    public Single<SystemWrapper<ListProdResponse>> noValidBox(String box, AlcListProduction prod) {
        return defer(() -> {
            GbrListPack pack = packRepository.findFirstByPackString(box);
            ListProdResponse resp = ListProdResponse.create(false, false, false, false, prod);
            if (pack == null) {
                return just(SystemWrapper.wrapper(getDescription(), resp));
            } else {
                AlcListProduction product = repository.findFirstByPacking(box);
                if (product != null) {
                    resp = ListProdResponse.create(false, false, true, true, product);
                    return just(SystemWrapper.wrapper(getDescription(), resp));
                }
            }
            resp = ListProdResponse.create(false, false, true, false, prod);
            return just(SystemWrapper.wrapper(getDescription(), resp));
        });
    }

    private void print(AlcLot lotResult) {
        String zpl = ZPLString.ZPLStringLote(lotResult);
        PrintService printer = ZPLPrintUtil.selectPrinterByLine(lotResult.getLine().getDescription());
        ZPLPrintUtil.print(printer, zpl);
    }

}
