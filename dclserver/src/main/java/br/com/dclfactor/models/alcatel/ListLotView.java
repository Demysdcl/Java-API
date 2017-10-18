/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "LIST_LOT_VIEW")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListLotView extends BaseEntity<BigInteger>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private BigInteger id;
    @Size(max = 255)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Size(max = 25)
    @Column(name = "LOTE")
    private String lote;
    @Size(max = 255)
    @Column(name = "PACK_STRING")
    private String packString;
    @Size(max = 40)
    @Column(name = "SKU")
    private String sku;
    
}
