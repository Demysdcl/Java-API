/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.observable.impl;

import br.com.dclfactor.models.alcatel.AlcAnything;
import br.com.dclfactor.repositories.AnythingRepository;
import br.com.dclfactor.service.impl.GenericObsServiceImpl;
import br.com.dclfactor.service.observable.AnythingObsService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("anythingObsService")
public class AnythingObsServiceImp extends GenericObsServiceImpl<AlcAnything, Integer>
    implements AnythingObsService{
    
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private AnythingRepository repository;
}
