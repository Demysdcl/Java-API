/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controller;

import br.com.dclfactor.entity.GroupProductionAndData;
import br.com.dclfactor.service.GroupProductionRepairService;
import java.io.Serializable;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping(path = "/REST")
public class GroupProductionDataController implements Serializable {

    @Autowired
    private GroupProductionRepairService service;

    @PostMapping("/repairs/findByDates")
    public GroupProductionAndData findByDates(@RequestBody String[] dates) {
        return service.findRepairsByDate(dates);
    }

    @PostMapping("/inspection/findByDates")
    public GroupProductionAndData findInspectionByDates(@RequestBody String[] dates) {
        return service.findInspectionByDate(dates);
    }

}
