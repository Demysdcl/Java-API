/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.observable;

import br.com.dclfactor.controllers.GenericObsControllerImpl;
import br.com.dclfactor.models.alcatel.AlcAnything;
import br.com.dclfactor.service.observable.AnythingObsService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping("/obs/anything")
public class AnythingObsController extends GenericObsControllerImpl<AlcAnything, Integer> {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private AnythingObsService service;
    
}
