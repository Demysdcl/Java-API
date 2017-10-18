/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "REMESSA_PALLET_VIEW")
@XmlRootElement
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemessaPalletView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @Getter
    @Setter
    private BigInteger id;

    @Getter
    @Setter
    @Size(max = 100)
    @Column(name = "REMESSA")
    private String remessa;

    @Getter
    @Setter
    @Size(max = 10)
    @Column(name = "PALLET_STRING")
    private String palletString;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "PACK_STRING")
    private String packString;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_1")
    private String imei1;

}
