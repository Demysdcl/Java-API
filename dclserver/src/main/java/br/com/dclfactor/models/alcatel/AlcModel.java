/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "USEFUL_MODEL")
@Getter
@Setter
@XmlRootElement
public class AlcModel extends BaseEntity<BigInteger>{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private BigInteger id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SKU")
    private int codSku;
    
    @Column(name = "COD_MODELO")
    private Integer codModelo;
    
    @Size(max = 20)
    @Column(name = "SKU")
    private String sku;
    
    @Size(max = 13)
    @Column(name = "EAN")
    private String ean;
    
    @Size(max = 20)
    @Column(name = "MODEL")
    private String model;
    
    @Size(max = 13)
    @Column(name = "MODEL_NAME")
    private String modelName;
    
    @Column(name = "QTY_BOX")
    private Integer qtyBox;
    
    @Column(name = "QTY_PALLET")
    private Integer qtyPallet;
    
    @Column(name = "QTY_LOT")
    private Integer qtyLot;

}
