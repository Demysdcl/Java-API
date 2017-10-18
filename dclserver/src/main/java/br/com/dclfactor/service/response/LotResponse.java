/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.response;

import br.com.dclfactor.models.alcatel.AlcLot;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
public class LotResponse implements Serializable{

    @Getter
    @Setter
    private String lote;

    @Getter
    @Setter
    private Integer qtyOp;

    @Getter
    @Setter
    private Integer prodOp;

    @Getter
    @Setter
    private Integer qtyLot;

    @Getter
    @Setter
    private Integer prodLot;
    
    public LotResponse(AlcLot lot) {
        lote = lot.getId();
        qtyOp = lot.getOp().getQuantity();
        prodOp = lot.getOp().getProdQty();
        qtyLot = lot.getQuantity();
        prodLot =lot.getQtyProd();
    }

}
