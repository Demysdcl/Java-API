package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.dclfactor.enumeration.StatusEnum;
import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.models.gbr.GbrSku;
import java.util.Date;

@Entity

@Table(name = "ALC_ORDER", schema = "db_accessadmin")
public class AlcOrder extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty(message = "Informe o Código da Ordem")

    @Column(name = "idorder")
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @ManyToOne
    @NotNull(message = "Selecione o SKU")
    private GbrSku sku;

    @Getter
    @Setter
    @ManyToOne
    private AlcUser user;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Getter
    @Setter
    @ManyToOne
    @NotNull(message = "Selecione o PPB")
    private AlcPpb ppb;

    @Getter
    @Setter
    @ManyToOne
    @NotNull(message = "Selecione a Linha")
    private GbrLine line;

    @Getter
    @Setter
    @Column(name = "dtcreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;

    @Getter
    @Setter
    @Column(name = "dtstart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtStart;

    @Getter
    @Setter
    @Column(name = "dtend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEnd;

    @Getter
    @Setter
    @NotNull(message = "Informe a quantidade")
    private Integer quantity;

    @Getter
    @Setter
    @Column(name = "PROD_QUANT")
    private Integer prodQty;

    @Getter
    @Setter
    @Column(name = "CHECKED_QUANT")
    private Integer checkedQty;

    @Getter
    @Setter
    @Column(name = "fullsku", length = 40)
    private String fullSku;

    @Getter
    @Setter
    @Column(name = "IS_ENGINE")
    private Boolean engine;

    @Override
    public String getDescription() {
        return quantity.toString();
    }

    public String createFullSku() {
        return AlcFullSku.createFullSku(sku.getSku(), ppb.getId());
    }

}
