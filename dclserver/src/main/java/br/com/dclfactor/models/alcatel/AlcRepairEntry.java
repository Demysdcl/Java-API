package br.com.dclfactor.models.alcatel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;
import br.com.dclfactor.models.gbr.GbrSerial;
import br.com.dclfactor.models.gbr.GbrSku;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_REPAIR", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcRepairEntry extends BaseEntity<Integer> {

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEntry;

    @Column(name = "DT_REPAIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRepair;

    @JoinColumn(name = "COD_LINE")
    @ManyToOne
    @NotNull(message = "Informe a Linha")
    private GbrLine line;

    @JoinColumn(name = "ID_POST")
    @ManyToOne
    @NotNull(message = "Informe o Posto")
    private AlcPost post;

    @JoinColumn(name = "ENTRY_USER")
    @ManyToOne
    private AlcUser entryUser;

    @JoinColumn(name = "COD_SKU")
    @ManyToOne
    @NotNull(message = "Informe o Modelo")
    private GbrSku sku;

    @Column(name = "STEP", length = 10)
    private String step;

    @JoinColumn(name = "ID_DEFECT")
    @ManyToOne
    @NotNull(message = "Informe o Defeito")
    private AlcDefect defect;

    @Column(name = "STATUS_ENG", length = 5)
    private String status;

    @Override
    public String getDescription() {
        return "";
    }

}
