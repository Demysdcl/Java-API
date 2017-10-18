/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.GroupProductionAndData;
import br.com.dclfactor.entity.alcatel.AlcDefect;
import br.com.dclfactor.repository.ProductionRepository;
import br.com.dclfactor.repository.RepairRepository;
import br.com.dclfactor.ui.DatesToBetween;
import java.io.Serializable;
import java.util.Date;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class GroupProductionRepairService implements Serializable {

    @Autowired
    private RepairRepository repository;

    @Autowired
    private ProductionRepository prodRepository;

    @Autowired
    private OQCInspectionService service;
    
    @SneakyThrows
    public GroupProductionAndData findRepairsByDate(String[] dates) {
        DatesToBetween db = new DatesToBetween(dates, "yyyy/MM/dd");
        return findRepairsByDate(db.getInicialDate(), db.getFinalDate());
    }

    public GroupProductionAndData findRepairsByDate(Date iniDate, Date finDate) {
        DatesToBetween dtb = new DatesToBetween(iniDate, finDate);
        GroupProductionAndData group = new GroupProductionAndData();
        group.setProduction(prodRepository.countPrtoductionPerFamily(dtb.getInicialDate(), dtb.getFinalDate()));
        group.setData(repository.findByDtEntryBetween(dtb.getInicialDate(), dtb.getFinalDate()));
        return group;
    }
    
    @SneakyThrows
    public GroupProductionAndData findInspectionByDate(String[] dates) {
        DatesToBetween db = new DatesToBetween(dates, "yyyy/MM/dd");
        return findInspectionByDate(db.getInicialDate(), db.getFinalDate());
    }

    public GroupProductionAndData findInspectionByDate(Date iniDate, Date finDate) {
        DatesToBetween dtb = new DatesToBetween(iniDate, finDate);
        GroupProductionAndData group = new GroupProductionAndData();
        group.setProduction(prodRepository.countPrtoductionPerFamily(dtb.getInicialDate(), dtb.getFinalDate()));
        group.setData(service.findByDates(dtb.getInicialDate(), dtb.getFinalDate()));
        return group;
    }
    

}
