package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTROL_IMEI_SKU", schema = "db_accessadmin", catalog = "ALCATEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ControlImeiSku extends BaseEntity<BigInteger> {

    @Id
    @GeneratedValue
    private BigInteger id;
   
    private static final long serialVersionUID = 1075278968718033978L;
    @Column(name = "ORDER_ID")
    private String order;

    @Column(name = "PALLET_STRING")
    private String pallet;

    @Column(name = "PACK_STRING")
    private String packing;

    @Column(name = "IMEI_1")
    private String imei;

     
    @Size(max = 100)
    @Column(name = "REMESSA")
    private String remessa;
    @Size(max = 40)
    @Column(name = "SKU")
    private String sku;
    @Size(max = 25)
    @Column(name = "LOTE")
    private String lote;
}
