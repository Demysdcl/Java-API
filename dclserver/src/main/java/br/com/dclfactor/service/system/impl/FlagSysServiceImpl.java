/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcFlag;
import br.com.dclfactor.repositories.FlagRepository;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.service.system.FlagSysService;
import io.reactivex.Single;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("flagSysService")
public class FlagSysServiceImpl extends GenericSystemServiceImpl<AlcFlag, String>
        implements FlagSysService {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private FlagRepository repository;

    @Override
    protected String getDescription() {
        return "System Flags";
    }

    @Override
    public Single<SystemWrapper<AlcFlag>> getNextLotKey(String keyValue) {
        return findById(keyValue)
                .flatMap((vlr) -> {
                    return saveNext(vlr, keyValue);
                });
    }

    private Single<SystemWrapper<AlcFlag>> saveNext(SystemWrapper<AlcFlag> found, String keyValue) {
        return Single.defer(() -> {
            AlcFlag any = found.getValue();
            if (any == null) {
                any = new AlcFlag(keyValue, 0);
            }
            any.setNextValue(any.getNextValue() + 1);
            found.setValue(getRepository().save(any));
            return Single.just(found);
        });
    }
}
