/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrListPack;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dclfactor.service.system.ListPackSysService;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/sys/box")
public class ListPackSysController extends GenericSysControllerImpl<GbrListPack, Integer> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private ListPackSysService service;

    @GetMapping("/exist/{packString}")
    public Single<SystemWrapper<GbrListPack>> findByBox(@PathVariable String packString) {
        return service.findByPack(packString);
    }

}
