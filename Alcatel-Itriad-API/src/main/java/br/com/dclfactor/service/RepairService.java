/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.alcatel.AlcRepair;
import br.com.dclfactor.repository.RepairRepository;
import br.com.dclfactor.ui.DatesToBetween;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class RepairService extends GenericAbstractService<AlcRepair, Integer> {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private RepairRepository repository;

    @SneakyThrows
    public List<AlcRepair> findByDates(String[] dates) {

        DatesToBetween db = new DatesToBetween(dates, "yyyy/MM/dd");
        return repository.findByDtEntryBetween(db.getInicialDate(), db.getFinalDate());

    }

}
