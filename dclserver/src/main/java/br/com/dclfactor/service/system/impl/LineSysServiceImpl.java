/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.repositories.LineRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.LineSysService;
import io.reactivex.Single;
import java.util.List;

@Service("lineObsService")
public class LineSysServiceImpl extends GenericSystemServiceImpl<GbrLine, Integer>
        implements LineSysService {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private LineRepository repository;

    @Override
    protected String getDescription() {
        return "Productions Lines";
    }

    @Override
    public Single<SystemWrapper<List<String>>> findLineNames() {
        return Single.just(SystemWrapper.wrapper(
                getDescription(), repository.findAllLines())
        );
    }

}
