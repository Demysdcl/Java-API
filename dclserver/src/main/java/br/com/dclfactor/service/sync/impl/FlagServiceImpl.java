/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.sync.impl;

import br.com.dclfactor.service.impl.GenericServiceImpl;
import br.com.dclfactor.models.alcatel.AlcFlag;
import br.com.dclfactor.repositories.FlagRepository;
import br.com.dclfactor.service.sync.FlagService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("flagService")
public class FlagServiceImpl extends GenericServiceImpl<AlcFlag, String> implements FlagService {
    
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private FlagRepository repository;
    
}
