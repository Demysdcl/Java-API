/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.gbr.GbrListPack;
import br.com.dclfactor.repositories.ListPackRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.ListPackSysService;
import io.reactivex.Single;

/**
 *
 * @author LimaD01
 */
@Service("listPackObsService")
public class ListPackSysServiceImpl extends GenericSystemServiceImpl<GbrListPack, Integer>
        implements ListPackSysService {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private ListPackRepository repository;

    @Override
    protected String getDescription() {
        return "Productions boxs";
    }

    @Override
    public Single<SystemWrapper<GbrListPack>> findByPack(String packString) {
        return Single.just(SystemWrapper.wrapper(
                getDescription(),
                 repository.findFirstByPackString(packString))
        );
    }

}
