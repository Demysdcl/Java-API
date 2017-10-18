/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Getter
@Setter
@XmlRootElement
public class GroupBox implements Serializable{

    private String GRP;
    private Date DataPacking;
    private Double WeightPack;
    private String PO;
    private String SKU;
    private String Batch;
    private String PL;
    private List<Serial> Serials;

    public GroupBox(List<FullProductView> views) {
        Serials = new ArrayList<>();
        FullProductView fpv = views.stream().findFirst().get();
        if (fpv != null) {
            GRP = fpv.getGrp();
            DataPacking = fpv.getDataPacking();
            WeightPack = fpv.getWeightPack();
            PO = fpv.getPO();
            Batch = fpv.getBatch();
            PL = fpv.getPl();
            SKU = fpv.getFullSku();
        }
        
        views.stream().forEach(view -> {
            Serial serial = new Serial(view.getSerialCode(), view.getImei1(),
                    view.getImei2(), view.getImeiData(), view.getWeight());
        });
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Serial {
        private String SerialCode;
        private String Imei1;
        private String Imei2;
        private Date ImeiData;
        private Double Weight;
    }

}
