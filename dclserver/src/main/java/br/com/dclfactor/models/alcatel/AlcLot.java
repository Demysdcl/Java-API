package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dclfactor.enumeration.StatusEnum;
import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "ALC_VOLUME", schema = "db_accessadmin")
@Entity
public class AlcLot extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_VOL", length = 25)
    @Id
    @Getter
@Setter
    private String id;

    @Getter
@Setter
    @JoinColumn(name = "ORDER_VOL")
    @ManyToOne
    private AlcOrder op;

    @Getter
@Setter
    @Column(name = "QTY_PROD")
    private Integer qtyProd;
@Getter
@Setter
    @Column(name = "QUANTITY")
    private Integer quantity;

@Getter
@Setter
    @Column(name = "DATE_CREATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreate;

@Getter
@Setter
    @Column(name = "DATE_FINISH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFinish;

@Getter
@Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 20)
    private StatusEnum status;  

    @Override
    public String getDescription() {
        return quantity + "";
    }

    public static AlcLot createNewLote(String id, AlcOrder op) {
        AlcLot lot = new AlcLot();
        lot.setId(id);
        lot.setOp(op);
        lot.setDtCreate(new Date());
        lot.setQuantity(op.getSku().getQtdProdutoVolume());
        lot.setQtyProd(0);
        lot.setStatus(StatusEnum.ATIVO);
        return lot;
    }

    public GbrLine getLine() {
        if (op == null) {
            return null;
        }
        return op.getLine();
    }

}
    