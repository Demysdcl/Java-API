/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.wrapper;

import br.com.dclfactor.entity.alcatel.AlcListProduction;
import br.com.dclfactor.entity.gbr.GbrPacking;
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
public class GroupBox implements Serializable {

    private String GRP;
    private Date DatePacking;
    private Double WeightPack;
    private String PO;
    private String SKU;
    private String simpleSku;
    private String Batch;
    private String PL;
    private List<Serial> Serials;

    public GroupBox(AlcListProduction prod, List<GbrPacking> packings) {
        if (!packings.isEmpty()) {
            GbrPacking pack = packings.get(0);
            GRP = pack.getPackString();
            DatePacking = pack.getDatePacking();
            WeightPack = pack.getWeight();
            PO = prod.getOp().getId();
            SKU = prod.getOp().getFullSku();
            simpleSku = prod.getOp().getSimpleSku();
            Batch = prod.getLote();
            PL = prod.getLine().getName();
        }
        Serials = new ArrayList<>();
        packings.forEach(packing -> {
            Serial serial = new Serial(
                    packing.getSerial().getSerial(), 
                    packing.getSerial().getImei1(), 
                    packing.getSerial().getImei2(), 
                    packing.getSerial().getImeiDate(), 
                    packing.getSerial().getWeight());
            Serials.add(serial);
        });
    }

    @Getter
    @AllArgsConstructor
    public class Serial {
        private  String SerialCode;
        private  String Imei1;
        private  String Imei2;
        private  Date ImeiData;
        private  Double Weight;
    }

}
