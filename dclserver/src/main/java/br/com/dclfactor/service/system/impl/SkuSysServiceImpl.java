/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.repositories.SkuRepository;
import br.com.dclfactor.models.gbr.GbrSku;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.SkuSysService;
import io.reactivex.Single;
import java.util.List;

/**
 *
 * @author LimaD01
 */
@Service("skuObsService")
public class SkuSysServiceImpl extends GenericSystemServiceImpl<GbrSku, Integer>
        implements SkuSysService {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private SkuRepository repository;

    @Override
    protected String getDescription() {
        return "SKU";
    }

    @Override
    public Single<SystemWrapper<List<String>>> findSkuName() {
        return Single.just(SystemWrapper.wrapper(
                getDescription(), repository.findAllSku())
        );
    }

}
