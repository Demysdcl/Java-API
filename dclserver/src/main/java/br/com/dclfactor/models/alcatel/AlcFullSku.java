package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ALC_FULL_SKU", schema = "db_accessadmin")
@NoArgsConstructor
@AllArgsConstructor
public class AlcFullSku extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FULL_SKU", length = 60)
    private String id;

    @Column(name = "BATTERY")
    private Boolean battery;

    @Column(name = "CHARGER")
    private Boolean charger;

    @Column(name = "MEMORY")
    private Boolean memory;

    @Column(name = "SD_CARD")
    private Boolean sdCard;

    @Column(name = "MAIN_BOARD")
    private Boolean main;

    @Column(name = "SUB_BOARD")
    private Boolean sub;

    @Column(name = "AUXILIARY_1")
    private Boolean auxiliary1;

    @Column(name = "AUXILIARY_2")
    private Boolean auxiliary2;

    @Column(name = "BOARD_QTY")
    private Integer boardQty;

    @Column(name = "HAS_SD_CARD")
    private Boolean hasSDCard;

    @Column(name = "HAS_DTV")
    private Boolean hasDTV;

    public static String createFullSku(String sku, String ppb) {
        return getHeaderSku(sku) + "-" + ppb;
    }

    public static String getHeaderSku(String sku) {
        String[] splits = sku.split("-");
        StringBuilder sbFull = new StringBuilder();
        if (splits.length > 1) {
            sbFull.append(splits[0]).append("-").append(splits[1]);
        } else {
            sbFull.append(sku);
        }
        return sbFull.toString();
    }

    @Override
    public String getDescription() {
        return "";
    }

}
