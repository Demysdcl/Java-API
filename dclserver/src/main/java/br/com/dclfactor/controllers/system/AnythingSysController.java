/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcAnything;
import br.com.dclfactor.service.system.AnythingSysService;
import io.reactivex.Single;
import java.io.Serializable;
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
@RequestMapping("/sys/anything")
public class AnythingSysController extends GenericSysControllerImpl<AlcAnything, Integer> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)    
    private AnythingSysService service;        
    
    @GetMapping("/next/{keyValue}")
    public Single<SystemWrapper> getNextLotKey(@PathVariable String keyValue){
        return service.getNextLotKey(keyValue);
    }
    
}
