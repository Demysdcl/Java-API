/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

import br.com.dclfactor.entity.BaseEntity;
import br.com.dclfactor.entity.gbr.GbrSku;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@XmlRootElement
@Table(name = "ALC_ORDER", schema = "db_accessadmin")
public class AlcOp extends BaseEntity<String> {

    @Id
    @Column(name = "idorder")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @Column(name = "fullsku")
    private String fullSku;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "sku_cod_sku")
    private GbrSku sku;

    public String getFamily(){
        if(sku != null){
            return getSimpleSku().substring(0, 5);
        }
        return "";
    }
    
    public String getSimpleSku(){
        if(sku != null){
            return sku.getSku();
        }
        return "";
    }

}
