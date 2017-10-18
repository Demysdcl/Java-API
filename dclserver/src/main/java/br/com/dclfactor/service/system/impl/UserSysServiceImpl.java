/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.alcatel.AlcUser;
import br.com.dclfactor.repositories.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.UserSysService;

/**
 *
 * @author LimaD01
 */
@Service("userObsService")
public class UserSysServiceImpl extends GenericSystemServiceImpl<AlcUser, Integer> implements UserSysService{
    
    @Getter
    @Autowired
    private UserRepository repository;

    @Override
    protected String getDescription() {
        return "Users System";
    }
    
    
    
}
