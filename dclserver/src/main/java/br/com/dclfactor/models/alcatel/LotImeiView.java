package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LOT_IMEI_VIEW", schema = "db_accessadmin", catalog = "ALCATEL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LotImeiView extends BaseEntity<Long> {

    private static final long serialVersionUID = 5738163398156320896L;

    @Id
    private Long id;

    private String sku;

    @Column(name = "ORDER_ID")
    private String order;

    private String lote;

    @Column(name = "PACK_STRING")
    private String packing;

    @Column(name = "IMEI_1")
    private String imei;

    @Override
    public String getDescription() {
        return imei;
    }

    public String getLineToFile() {
        return sku + " \t " + imei;
    }

}
