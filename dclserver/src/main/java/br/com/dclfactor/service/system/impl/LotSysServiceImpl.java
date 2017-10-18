/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcFlag;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.repositories.LotRepository;
import br.com.dclfactor.repositories.OrderRepository;
import br.com.dclfactor.service.system.FlagSysService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.LotSysService;
import br.com.dclfactor.utils.DateUtil;
import io.reactivex.Single;
import java.util.List;

@Service("lotObsService")
public class LotSysServiceImpl extends GenericSystemServiceImpl<AlcLot, String>
        implements LotSysService {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private LotRepository repository;

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private OrderRepository opRepository;

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private FlagSysService flagService;

    @Override
    protected String getDescription() {
        return "Productions Lots";
    }

    @Override
    public Single<SystemWrapper<AlcLot>> getLoteByOrder(String idOp) {
        return findActivatedByOp(idOp).flatMap((SystemWrapper<AlcLot> result) -> {
            AlcLot lot = result.getValue();
            if (lot == null) {
                return createNewLot(idOp);
            }
            return Single.just(SystemWrapper.wrapper("Lot by " + idOp, lot));
        });
    }

    public Single<SystemWrapper<AlcLot>> createNewLot(String idOp) {
        return Single.defer(() -> {
            String flagHead = "L" + DateUtil.getCurrentYear().toString().substring(2, 4);
            return flagService.getNextLotKey(flagHead)
                    .flatMap((SystemWrapper<AlcFlag> vlr) -> {
                        String lotId = vlr.getValue().getNextLotId();
                        return findById(lotId).flatMap((SystemWrapper<AlcLot> result) -> {
                            AlcLot lot = result.getValue();
                            if (lot == null) {
                                lot = AlcLot.createNewLote(lotId, opRepository.findOne(idOp));
                                return save(lot);
                            }
                            return createNewLot(idOp);
                        });
                    });

        });
    }

    public Single<SystemWrapper<AlcLot>> findActivatedByOp(String idOp) {
        return Single.defer(() -> {
            List<AlcLot> list = repository.findOneActivatedByOp(idOp);
            AlcLot lot = list.isEmpty() ? null : list.get(0);
            return Single.just(SystemWrapper.wrapper("Lot Activated by id OP", lot));
        });
    }

}
