/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controller;

import br.com.dclfactor.entity.alcatel.AlcDefect;
import br.com.dclfactor.entity.gbr.GbrSerial;
import br.com.dclfactor.entity.wrapper.GroupBox;
import br.com.dclfactor.service.DefectService;
import br.com.dclfactor.service.GroupBoxService;
import br.com.dclfactor.service.SerialService;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping("REST/WebServiceProduction")
public class ProductController implements Serializable {

    @Autowired
    private GroupBoxService service;
    
    @Autowired
    private SerialService serialService;
    
    @Autowired
    private DefectService defService;
    

    /**
     *
     * @param lote
     * @return
     */
    @GetMapping("/findByBatch/{lote}")
    public WrapperResponse getGroupBoxs(@PathVariable String lote) {
        return new WrapperResponse(service.getGroupBoxs(lote));
    }
    
    
    @GetMapping("/getDefects")
    public List<AlcDefect> findAll(){
    	return defService.findAll();
    }
    
    @GetMapping("findByImei/{imei}")
    public GbrSerial exists(@PathVariable String imei){
        return serialService.findByCode(imei);
    }

    /**
     *
     * @param groupBoxes
     * @return
     */
    @PostMapping(path = "/findByGroupBoxes")
    public WrapperResponse getGroupBoxsBypacking(@RequestBody String [] groupBoxes ) {
        return new WrapperResponse(service.getGroupBoxs(groupBoxes));
    }

    @Getter
    private class WrapperResponse {
        private final List<GroupBox> groupBoxs;
        public WrapperResponse(List<GroupBox> groupBoxs) {
            this.groupBoxs = groupBoxs;
        }

    }

}
