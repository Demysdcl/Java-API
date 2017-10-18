/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Getter
@Setter
@Entity
@Table(name = "FULL_PRODUCT_VIEW", schema = "db_accessadmin",
        catalog = "ALCATEL")
@XmlRootElement
public class FullProductView extends BaseEntity {

    @Id
    private Long id;
    
    private String grp;
    
    @Column(name = "datapacking")
    private Date dataPacking;
    
    @Column(name = "lweightpack")
    private Double weightPack;
    
    private String sku;
    private String ppb;
    private String pl;
    
    @Column(name = "serialcode")
    private String serialCode;
    
    private String imei1;
    
    private String imei2;
    
    @Column(name = "imeidata")
    private Date imeiData;
    
    private Double weight;

    @Transient
    private String batch;

    @Transient
    private String po;

    @Transient
    private AlcListProduction production;
    
    public String getFullSku() {
        String[] cutSku = sku.split("-");
        return cutSku[0] + "-" + cutSku[1] + "-" + ppb;
    }
    
    public String getBatch(){
        return production.getLote();
    }
    
    public String getPO(){
        return production.getOp();
    }
    
}
