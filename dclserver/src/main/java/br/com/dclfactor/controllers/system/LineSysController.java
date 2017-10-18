/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.service.system.LineSysService;
import io.reactivex.Single;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping("/sys/line")
public class LineSysController extends GenericSysControllerImpl<GbrLine, Integer> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private LineSysService service;
    
    @GetMapping(path = "/name")
    public Single<SystemWrapper<List<String>>> linesName(){
        return service.findLineNames();
    } 

}
