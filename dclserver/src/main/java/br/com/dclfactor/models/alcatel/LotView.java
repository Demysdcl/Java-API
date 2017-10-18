/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import java.math.BigInteger;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "LOT_VIEW")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LotView extends BaseEntity<BigInteger>{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LIST")
    private int idList;
    @Column(name = "dtPallet")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPallet;
    @Size(max = 255)
    @Column(name = "PACKING")
    private String packing;
    @Column(name = "LINE")
    private Integer line;
    @Size(max = 25)
    @Column(name = "ID_LOTE")
    private String idLote;
    @Size(max = 255)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "RESP_PALLET")
    private Integer respPallet;
    @Size(max = 255)
    @Column(name = "order_idorder")
    private String orderIdorder;
    @Size(max = 40)
    @Column(name = "fullSku")
    private String fullSku;
    
}
