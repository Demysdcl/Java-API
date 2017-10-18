/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.observable.impl;

import br.com.dclfactor.models.alcatel.AlcOrder;
import br.com.dclfactor.repositories.OrderRepository;
import br.com.dclfactor.service.impl.GenericObsServiceImpl;
import br.com.dclfactor.service.observable.OpObsService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("opObsService")
public class OpObsServiceImpl extends GenericObsServiceImpl<AlcOrder, String> 
        implements OpObsService{
    
    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private OrderRepository repository;
    
}
