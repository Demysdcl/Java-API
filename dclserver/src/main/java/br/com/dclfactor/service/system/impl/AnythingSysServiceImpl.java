/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.service.system.AnythingSysService;
import br.com.dclfactor.models.alcatel.AlcAnything;
import br.com.dclfactor.repositories.AnythingRepository;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import io.reactivex.Single;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("anythingSysService")
public class AnythingSysServiceImpl extends GenericSystemServiceImpl<AlcAnything, Integer>
        implements AnythingSysService {
    
    @Override
    protected String getDescription() {
        return "Test Anything";
    }
    
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private AnythingRepository repository;
    
    public Single<SystemWrapper<AlcAnything>> findByKeyValue(String keyValue) {
        return Single.just(
                SystemWrapper.wrapper(
                        getDescription(),
                        getRepository().findByKeyValue(keyValue)
                ));
    }
    
    @Override
    public Single<SystemWrapper> getNextLotKey(String keyValue) {
        return findByKeyValue(keyValue)
                .flatMap((vlr) -> {
                    AlcAnything any = vlr.getValue();
                    if (any == null) {
                        any = new AlcAnything(keyValue, 0);
                        
                    }
                    any.setNextValue(any.getNextValue() + 1);
                    vlr.setValue(getRepository().save(any));
                    return Single.just(vlr);
                });
    }
    
}
