/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.AlcListProduction;
import br.com.dclfactor.entity.FullProductView;
import br.com.dclfactor.entity.GroupBox;
import br.com.dclfactor.repository.FullProductRepository;
import br.com.dclfactor.repository.ProductionRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class GroupBoxService implements Serializable{
    
    @Autowired
    private ProductionRepository repository;
    
    @Autowired
    private FullProductRepository productRepository;
    
    public List<GroupBox> getGroupBoxs(String lote){
        List<GroupBox> groupBoxs = new ArrayList<>();
        
        List<AlcListProduction> list = repository.findByLote(lote);
        list.stream().forEach(prod -> {
            List<FullProductView> fpvs = productRepository.findByGrp(prod.getPacking()); 
            fpvs.forEach(pdt -> {
                pdt.setProduction(prod);
            });
            GroupBox box = new GroupBox(fpvs);
        });
        return groupBoxs;
    }
    
}
