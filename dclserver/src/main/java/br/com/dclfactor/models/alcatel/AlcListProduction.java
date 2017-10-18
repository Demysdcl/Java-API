package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "ALC_LOT_LIST", schema = "db_accessadmin")
@XmlRootElement
public class AlcListProduction extends BaseEntity<Integer> {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_LIST")
    @Getter
    @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @Getter
    @Setter
    private AlcOrder op;

    @ManyToOne
    @JoinColumn(name = "RESP_PALLET")
    @Getter
    @Setter
    private AlcUser respPallet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dtpallet")
    @Getter
    @Setter
    private Date dtPallet;

    @Column(unique = true, name = "PACKING", length = 15)
    @Getter
    @Setter
    private String packing;

    @Column(unique = true, name = "PACK_STRING", length = 15)
    @Getter
    @Setter
    private String packString;

    @ManyToOne
    @JoinColumn(name = "ID_LOTE")
    @Getter
    @Setter
    private AlcLot lote;

    @ManyToOne
    @JoinColumn(name = "LINE")
    @Getter
    @Setter
    private GbrLine line;

    public AlcListProduction(String packing, AlcLot lot) {
        this.packing = packing;
        this.packString = packing;
        this.lote = lot;
        this.op = lot.getOp();
        this.line = lot.getLine();
        this.dtPallet = new Date();
    }

    @Override
    public String getDescription() {
        return "" + op + " " + lote;
    }

}
