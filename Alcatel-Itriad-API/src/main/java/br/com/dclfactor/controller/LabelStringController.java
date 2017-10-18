/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controller;

import br.com.dclfactor.entity.gbr.GbrLabelString;
import br.com.dclfactor.repository.vo.PalleteZplVO;
import br.com.dclfactor.service.LabelZplService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping("REST/WebServiceProduction")
public class LabelStringController implements Serializable{
    
    @Autowired
    private LabelZplService service;
    
    @GetMapping("/zpl/{sku}")
    public  ResponseEntity<PalleteZplVO> findBySku(@PathVariable String sku){
        PalleteZplVO vo = service.findBySku(sku);
        if(vo != null){
            return new ResponseEntity<>(vo , HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
}
