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
import br.com.dclfactor.entity.gbr.GbrLine;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ALC_LOT_LIST", schema = "db_accessadmin")
@XmlRootElement
public class AlcListProduction extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "ID_LIST")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private AlcOp op;

    @Getter
    @Setter
    @Column(unique = true, name = "PACKING", length = 15)
    private String packing;

    @Getter
    @Setter
    @Column(unique = true, name = "PACK_STRING", length = 15)
    private String packString;

    @Getter
    @Setter
    @Column(name = "ID_LOTE")
    private String lote;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "LINE")
    private GbrLine line;

    @Getter
    @Setter
    @Column(name="FAMILY")
    private String family;
    
    @Getter
    @Setter
    @Column(name = "dtpallet")
    private Date dtPallet;

}
