/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.gbr;

import br.com.dclfactor.entity.BaseEntity;
import java.util.Date;
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

@Table(name = "GBR_LIST_PACK", schema = "dbo", catalog = "GBR")
public class GbrPacking extends BaseEntity<Long> {

    @Getter
    @Setter
    @Id
    @Column(name = "COD_LIST_PACK")
    private Long id;

    @Getter
    @Setter
    private String packString;

    @Getter
    @Setter
    @Column(name = "PESO")
    private Double weight;

    @Getter
    @Setter
    @Column(name = "DATA")
    private Date datePacking;

    
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "SERIAL", referencedColumnName = "SERIAL")
    private GbrSerial serial;

}
