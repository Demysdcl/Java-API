/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrSku;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dclfactor.service.system.SkuSysService;
import io.reactivex.Single;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author LimaD01
 */

@RequestMapping("/sys/sku")
@RestController
public class SkuSysController extends GenericSysControllerImpl<GbrSku, Integer>{
    
    @Getter(value = AccessLevel.PROTECTED)
    @Autowired
    private SkuSysService service;
    
    @GetMapping("/name")
    public Single<SystemWrapper<List<String>>> findAllSku(){
        return service.findSkuName();
    }
    
}
