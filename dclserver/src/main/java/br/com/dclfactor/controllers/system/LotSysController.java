/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.service.system.LotSysService;
import br.com.dclfactor.service.response.LotResponse;
import io.reactivex.Single;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */

@RestController
@RequestMapping("/sys/lot")
public class LotSysController extends GenericSysControllerImpl<AlcLot, String>{
    
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private LotSysService service;
    
    @GetMapping("/lotByOp/{idOp}")
    public Single<LotResponse> getLotByIdOp(@PathVariable("idOp") String idop){
        return service.getLoteByOrder(idop).flatMap(mapper -> {
            return Single.just(new LotResponse(mapper.getValue()));
        });
    }
    
}
