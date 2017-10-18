package br.com.dclfactor.entity.alcatel;

import br.com.dclfactor.entity.BaseEntity;
import br.com.dclfactor.entity.gbr.GbrLine;
import br.com.dclfactor.entity.gbr.GbrSerial;
import br.com.dclfactor.entity.gbr.GbrSku;
import br.com.dclfactor.ui.DateUtil;
import java.time.Duration;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_REPAIR", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcRepair extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_REPAIR")
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "ID_SERIAL")
    @ManyToOne
    @NotNull(message = "Informe o Serial")
    private GbrSerial serialID;

    @Column(name = "DT_ENTRY")
    private Date dtEntry;

    @JoinColumn(name = "COD_LINE")
    @ManyToOne
    @NotNull(message = "Informe a Linha")
    private GbrLine line;

    @Column(name = "DT_REPAIR")
    private Date dtRepair;

    @JoinColumn(name = "ID_POST")
    @ManyToOne
    @NotNull(message = "Informe o Posto")
    private AlcPost post;

    @JoinColumn(name = "ID_ORIGIN")
    @ManyToOne
    @NotNull(message = "Informe a Origem")
    private AlcOrigin origin;

    @JoinColumn(name = "TECHNICAL")
    @ManyToOne
    private AlcUser technical;

    @JoinColumn(name = "ENTRY_USER")
    @ManyToOne
    private AlcUser entryUser;

    @JoinColumn(name = "COD_SKU")
    @ManyToOne
    @NotNull(message = "Informe o Modelo")
    private GbrSku sku;

    @JoinColumn(name = "ID_ACTION")
    @ManyToOne
    @NotNull(message = "Informe a Ação")
    private AlcAction action;

    @Column(name = "STEP", length = 10)
    private String step;

    @JoinColumn(name = "ID_DEFECT")
    @ManyToOne
    @NotNull(message = "Informe o Defeito")
    private AlcDefect defect;

    @JoinColumn(name = "ID_REASON")
    @ManyToOne
    private AlcReason reason;

    @Column(name = "OBSERVATION")
    private String observation;

    @Column(name = "COMPONENT")
    private String component;

    @Column(name = "STATUS_ENG", length = 5)
    private String status;

    @Column(name = "DURATION_TIME")
    private Long durationTime;

    @Transient
    private AlcComponent comp;

    public String getTime() {
        return DateUtil.formatDuration(durationTime);
    }

    public String getDurationRepair() {
        if (dtRepair != null) {
            Duration duration = Duration.between(dtEntry.toInstant(),
                    dtRepair.toInstant());
            return DateUtil.formatDuration(duration.getSeconds());
        }
        return null;
    }

}
