/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.alcatel.AlcPpb;
import br.com.dclfactor.repositories.PpbRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.PpbSysService;

/**
 *
 * @author LimaD01
 */
@Service("ppbObsService")
public class PpbSysServiceImpl extends GenericSystemServiceImpl<AlcPpb, String>
        implements PpbSysService {

    @Getter(AccessLevel.PROTECTED)
    @Autowired
    private PpbRepository repository;

    @Override
    protected String getDescription() {
        return "PPB";
    }

}
