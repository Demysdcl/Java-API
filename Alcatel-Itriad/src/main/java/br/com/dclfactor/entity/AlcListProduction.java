/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity;

/**
 *
 * @author LimaD01
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "ALC_LOT_LIST", schema = "db_accessadmin")
@Getter
@XmlRootElement
@Setter
public class AlcListProduction extends BaseEntity<Long> {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_LIST")
    private Long id;

    @Column(name = "ORDER_ID")
    private String op;

    @Column(unique = true, name = "PACKING", length = 15)
    private String packing;

    @Column(unique = true, name = "PACK_STRING", length = 15)
    private String packString;

    @Column(name = "ID_LOTE")
    private String lote;

}
