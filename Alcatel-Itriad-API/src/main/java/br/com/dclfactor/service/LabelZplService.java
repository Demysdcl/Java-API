/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.gbr.GbrLabelString;
import br.com.dclfactor.repository.LabelStringRepository;
import br.com.dclfactor.repository.vo.PalleteZplVO;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class LabelZplService extends GenericAbstractService<GbrLabelString, Long> {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private LabelStringRepository repository;

    public PalleteZplVO findBySku(String sku) {
        return repository.findBySku(sku, "PALLET");
    }

}
