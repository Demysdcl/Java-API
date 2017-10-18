/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controller;

import br.com.dclfactor.entity.GroupBox;
import br.com.dclfactor.service.GroupBoxService;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping( name = "GroupBox", produces={"application/hal+json", "application/json"})
public class ProductController implements Serializable{
    
    @Autowired
    private GroupBoxService service;
    
    @GetMapping("/{lote}")
    public List<GroupBox> getGroupBoxs(@PathVariable String lot){
        return service.getGroupBoxs(lot);
    }
 
    @GetMapping("/test")
    public String teste(){
        return "Test Spring";
    }
    
}
