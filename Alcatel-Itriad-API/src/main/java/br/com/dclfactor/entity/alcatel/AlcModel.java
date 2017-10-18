/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.dclfactor.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "USEFUL_MODEL", schema = "db_accessadmin")
@XmlRootElement
public class AlcModel extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SKU")
    private Integer codSku;

    @Getter
    @Setter
    @Column(name = "COD_MODELO")
    private Integer codModelo;

    @Getter
    @Setter
    @Size(max = 20)
    @Column(name = "SKU")
    private String sku;

    @Getter
    @Setter
    @Size(max = 13)
    @Column(name = "EAN")
    private String ean;

    @Getter
    @Setter
    @Size(max = 20)
    @Column(name = "MODEL")
    private String model;

    @Getter
    @Setter
    @Size(max = 13)
    @Column(name = "MODEL_NAME")
    private String modelName;

    @Getter
    @Setter
    @Column(name = "QTY_BOX")
    private Integer qtyBox;

    @Getter
    @Setter
    @Column(name = "QTY_PALLET")
    private Integer qtyPallet;

    @Getter
    @Setter
    @Column(name = "QTY_LOT")
    private Integer qtyLot;

}
