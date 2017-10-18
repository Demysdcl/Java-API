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

@Table(name = "GBR_CAD_SMT_SERIAL", schema = "dbo", catalog = "GBR")
public class GbrSerial extends BaseEntity<Long> {

    @Id
    @Column(name = "COD_SMT")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "SERIAL")
    private String serial;

    @Getter
    @Setter
    @Column(name = "IMEI_1")
    private String imei1;

    @Getter
    @Setter
    @Column(name = "IMEI_2")
    private String imei2;

    @Getter
    @Setter
    @Column(name = "DATA_LINHA_IMEI")
    private Date imeiDate;

    @Getter
    @Setter
    @Column(name = "PESO")
    private Double weight;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="COD_SKU", referencedColumnName = "COD_SKU")
    private GbrSku sku;
    
}
