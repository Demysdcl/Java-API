/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.ListProdResponse;
import br.com.dclfactor.models.alcatel.AlcListProduction;
import br.com.dclfactor.service.system.ListProdSysService;
import io.reactivex.Single;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */

@RestController
@RequestMapping("/sys/prod")
public class ProdLotSysController extends GenericSysControllerImpl<AlcListProduction, Integer> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private ListProdSysService service;
    
    @PostMapping("/{lotId}/{box}")
    public Single<ListProdResponse> processProduction(@PathVariable String lotId,
            @PathVariable String box){
        
        return service.processProduction(lotId, box).flatMap(resp -> {
            return Single.just(resp.getValue());
        });
    
    }

}
