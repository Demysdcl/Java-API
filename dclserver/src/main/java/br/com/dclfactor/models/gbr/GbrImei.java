/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.gbr;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_IMEI", schema = "dbo", catalog = "GBR")
@XmlRootElement
public class GbrImei extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_IMEI")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "COD_SMT")
    private Integer codSmt;

    @Getter
    @Setter
    @Column(name = "IMEI")
    private String imei;

    @Getter
    @Setter
    @Column(name = "ORDEM")
    private Integer ordem;

    @Getter
    @Setter
    @Column(name = "FLAG_IMEI")
    private Boolean flagImei;

    @Getter
    @Setter
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataImei;

    public GbrImei() {

    }

    public GbrImei(Integer id) {
        this.id = id;
    }

}
