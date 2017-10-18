package br.com.dclfactor.models.alcatel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.models.gbr.GbrSku;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ALC_TARGET_HOUR", schema = "db_accessadmin")
public class AlcTargetHour extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_TARGET")
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "COD_LINE")
    @NotNull(message = "Informe a linha")
    @ManyToOne
    private GbrLine line;

    @JoinColumn(name = "COD_SKU")
    @NotNull(message = "Informe o SKU")
    @ManyToOne
    private GbrSku sku;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_START")
    private Date dtStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_END")
    private Date dtEnd;

    @Column(name = "VALUE")
    @NotNull(message = "Informe o valor")
    private Integer value;

    @Override
    public String getDescription() {
        return line.getDescription() + " " + sku.getSku() + " " + value;
    }

}
