/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.gbr;

/**
 *
 * @author LimaD01
 */
import br.com.dclfactor.entity.BaseEntity;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_SKU", schema = "dbo", catalog = "GBR")
@Getter
@Setter
@XmlRootElement
public class GbrSku extends BaseEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SKU")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "SKU")
    private String sku;

    @ManyToOne
    @JoinColumn(name = "COD_MODELO")
    private GbrModel model;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "COR")
    private String cor;

    @Column(name = "SAPCODE")
    private String sapcode;

    @Column(name = "EAN")
    private String ean;

    @Column(name = "QTD_PRODUTO_COLETIVO")
    private Integer qtyBox;

    public GbrSku() {
    }

    public GbrSku(Integer codSku) {
        this.id = codSku;
    }

    public String getFamily() {
        return sku.substring(0, 5);
    }

}
