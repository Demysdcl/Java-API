/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.alcatel.AlcListProduction;
import br.com.dclfactor.entity.gbr.GbrPacking;
import br.com.dclfactor.entity.wrapper.GroupBox;
import br.com.dclfactor.repository.PackingRepository;
import br.com.dclfactor.repository.ProductionRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class GroupBoxService implements Serializable {

    @Autowired
    private ProductionRepository repository;

    @Autowired
    private PackingRepository packingRepository;

    public List<GroupBox> getGroupBoxs(String lote) {
        return convert(repository.findByLote(lote));
    }

    public List<GroupBox> getGroupBoxs(String[] groupBoxes) {
        return convert(repository.findByPackStringIn(Arrays.asList(groupBoxes)));
    }

    private List<GroupBox> convert(List<AlcListProduction> list) {
        
        List<GroupBox> groupBoxs = new ArrayList<>();
        list.forEach(prod -> {
            List<GbrPacking> packs = packingRepository.findByPackString(prod.getPackString());
            groupBoxs.add(new GroupBox(prod, packs));
        });
        return groupBoxs;
    
    }

}
