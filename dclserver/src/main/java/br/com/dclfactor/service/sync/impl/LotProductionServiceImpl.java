/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.sync.impl;

import br.com.dclfactor.service.impl.GenericServiceImpl;
import br.com.dclfactor.models.alcatel.AlcListProduction;
import br.com.dclfactor.repositories.ListProdRepository;
import br.com.dclfactor.service.sync.LotProductionService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("lotProductionService")
public class LotProductionServiceImpl extends GenericServiceImpl<AlcListProduction, Integer>
        implements LotProductionService {

    @Getter(value = AccessLevel.PROTECTED)
    private ListProdRepository repository; 
 
}
