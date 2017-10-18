/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Getter
@Setter
@XmlRootElement
@Table(name = "PACKING_SERIAL_VIEW",
        schema = "db_accessadmin")
public class PackingSerialView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @NotNull
    @Basic(optional = false)
    @Column(name = "ID_SERIAL", insertable = false, updatable = false)
    private int idSerial;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "PACKING", insertable = false, updatable = false)
    private String packing;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "SERIAL", insertable = false, updatable = false)
    private String serial;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_1", insertable = false, updatable = false)
    private String imei1;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_2", insertable = false, updatable = false)
    private String imei2;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_3", insertable = false, updatable = false)
    private String imei3;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_4", insertable = false, updatable = false)
    private String imei4;

    @Getter
    @Setter
    @Column(name = "LINE_FT", insertable = false, updatable = false)
    private Integer lineFt;

    @Getter
    @Setter
    @Column(name = "LINE_IMEI", insertable = false, updatable = false)
    private Integer lineImei;

    @Getter
    @Setter
    @Column(name = "LINE_INDIVIDUAL", insertable = false, updatable = false)
    private Integer lineIndividual;

    @Getter
    @Setter
    @Column(name = "LINE_COLETIVA", insertable = false, updatable = false)
    private Integer lineColetiva;

    @Getter
    @Setter
    @Column(name = "LINE_PALLET", insertable = false, updatable = false)
    private Integer linePallet;

    @Getter
    @Setter
    @Size(max = 20)
    @Column(name = "HOSTNAME", insertable = false, updatable = false)
    private String hostname;

    @Getter
    @Setter
    @Column(name = "DATE_FT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFt;

    @Getter
    @Setter
    @Column(name = "DATE_IMEI", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateImei;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_COLETIVA", insertable = false, updatable = false)
    private Date dateColetiva;

    @Getter
    @Setter
    @Column(name = "DATE_PALLET", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePallet;

    @Getter
    @Setter
    @Column(name = "DT_CREATION", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreation;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERIAL", insertable = false, updatable = false)
    private int idSerial1;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "PACKING", insertable = false, updatable = false)
    private String packing1;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "SERIAL", insertable = false, updatable = false)
    private String serial1;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_1", insertable = false, updatable = false)
    private String imei11;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_2", insertable = false, updatable = false)
    private String imei21;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_3", insertable = false, updatable = false)
    private String imei31;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_4", insertable = false, updatable = false)
    private String imei41;

    @Getter
    @Setter
    @Column(name = "LINE_FT", insertable = false, updatable = false)
    private Integer lineFt1;

    @Getter
    @Setter
    @Column(name = "LINE_IMEI", insertable = false, updatable = false)
    private Integer lineImei1;

    @Getter
    @Setter
    @Column(name = "LINE_INDIVIDUAL", insertable = false, updatable = false)
    private Integer lineIndividual1;

    @Getter
    @Setter
    @Column(name = "LINE_COLETIVA", insertable = false, updatable = false)
    private Integer lineColetiva1;

    @Getter
    @Setter
    @Column(name = "LINE_PALLET", insertable = false, updatable = false)
    private Integer linePallet1;

    @Getter
    @Setter
    @Size(max = 20)
    @Column(name = "HOSTNAME", insertable = false, updatable = false)
    private String hostname1;

    @Getter
    @Setter
    @Column(name = "DATE_FT", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFt1;

    @Getter
    @Setter
    @Column(name = "DATE_IMEI", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateImei1;

    @Getter
    @Setter
    @Column(name = "DATE_COLETIVA", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateColetiva1;

    @Getter
    @Setter
    @Column(name = "DATE_PALLET", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePallet1;

    @Getter
    @Setter
    @Column(name = "DT_CREATION", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreation1;

}
