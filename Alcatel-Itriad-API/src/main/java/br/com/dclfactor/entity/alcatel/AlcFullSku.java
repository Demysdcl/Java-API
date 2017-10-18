/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

/**
 *
 * @author LimaD01
 */
import br.com.dclfactor.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ALC_FULL_SKU", schema = "db_accessadmin")
@NoArgsConstructor
@AllArgsConstructor
public class AlcFullSku extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FULL_SKU", length = 60)
    private String fullSku;

    @Override
    public String getId() {
        return fullSku;
    }

    public static String createFullSku(String sku, String ppb) {
        return getHeaderSku(sku) + "-" + ppb;
    }

    public static String getHeaderSku(String sku) {
        String[] splits = sku.split("-");
        StringBuilder sbFull = new StringBuilder();
        if (splits.length > 1) {
            sbFull.append(splits[0]).append("-").append(splits[1]);
        } else {
            sbFull.append(sku);
        }

        return sbFull.toString();
    }

}
