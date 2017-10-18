/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository.vo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
public class CountProductionVO implements Serializable {

    @Getter
    @Setter
    private Object family;

    @Getter
    @Setter
    private Number qtyProductPerBox;

    @Getter
    @Setter
    private Number qtyBoxs;

    public CountProductionVO(Object name, Number value, Number qtyBoxs) {
        this.family = name;
        this.qtyProductPerBox = value;
        this.qtyBoxs = qtyBoxs;
    }

    public Number getTotal() {
        return qtyBoxs.intValue() * qtyProductPerBox.intValue();
    }

}
