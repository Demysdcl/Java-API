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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.models.gbr.GbrModel;
import br.com.dclfactor.models.gbr.GbrSku;
import br.com.dclfactor.utils.DclStringUtil;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALC_DOWNTIME", schema = "db_accessadmin")
public class AlcDowntime extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "ID_DOWNTIME")
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "COD_LINE")
    @NotNull(message = "Informe a linha")
    private GbrLine line;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "COD_SKU")
    @NotNull(message = "Informe o SKU")
    private GbrSku sku;

    @Getter
    @Setter
    @Column(name = "FAILURE")
    private String failure;

    @Getter
    @Setter
    @Column(name = "LOST_MINUTES")
    @Temporal(TemporalType.TIME)
    @NotNull(message = "Informe os minutos")
    private Date lostMinutes;

    @Getter
    @Setter
    @Column(name = "HOUR_TARGET")
    private Integer hourTarget;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "MODEL")
    @NotNull(message = "Informe o Modelo")
    private GbrModel model;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "PPB")
    @NotNull(message = "Informe o PPB")
    private AlcPpb ppb;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ENTRY")
    @NotNull(message = "Informe a data")
    private Date dtEntry;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CREATED")
    private Date dtCreated;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT")
    @NotNull(message = "Informe o responsável")
    private AlcDepartment department;

    @Column(name = "INTERVAL", length = 20)
    @NotNull(message = "Informe o Intervalo")
    @Getter
    @Setter
    private String interval;

    @Getter
    @Setter
    @Column(name = "PRODUCED")
    private Integer produced;

    @ManyToOne
    @JoinColumn(name = "SHIFT")
    @NotNull(message = "Informe o Turno")
    @Getter
    @Setter
    private AlcShift shift;

    @ManyToOne
    @JoinColumn(name = "ID_FAILURE")
    @NotNull(message = "Informe o Motivo")
    @Getter
    @Setter
    private AlcFailure fail;

    @Column(name = "OBSERVATION")
    @Getter
    @Setter
    private String observation;

    public String getFullSku() {
        return DclStringUtil.createFullSku(getSku().getSku(), ppb.getId());
    }

    @Override
    public String getDescription() {
        long real = hourTarget - produced;
        return "SKU: " + getFullSku() + " Linha: " + line.getDescription()
                + " Perdido: " + real;
    }

}
