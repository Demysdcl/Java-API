/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.alcatel.AlcOQCInspection;
import br.com.dclfactor.repository.OQCInspectionRepository;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class OQCInspectionService extends GenericAbstractService<AlcOQCInspection, Integer> {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private OQCInspectionRepository repository;

    public List<AlcOQCInspection> findByDates(Date iniDate, Date finDate) {
        return repository.findByCreationDateBetween(iniDate, finDate);
    }

}
