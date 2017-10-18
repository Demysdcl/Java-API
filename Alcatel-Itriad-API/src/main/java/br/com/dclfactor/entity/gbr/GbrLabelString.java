/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.gbr;

import br.com.dclfactor.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_ETIQUETA_STRING", schema = "dbo", catalog = "GBR")
public class GbrLabelString extends BaseEntity<Long> {

    @Id
    @Getter
    @Setter
    @Column(name = "COD_ETIQUETA")
    private Long id;

    @Getter
    @Setter
    @Column(name = "STRING")
    private String zpl;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "COD_SKU")
    private GbrSku sku;
    
    @Getter
    @Setter
    @Column(name = "TIPO")
    private String type;
    
}
