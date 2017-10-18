package br.com.dclfactor.models.alcatel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrSerial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_ENGINE", schema = "db_accessadmin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlcEngine extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SERIAL", length = 30)
    private String id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ENG")
    private AlcOrder orderEng;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_PASS")
    private Date dtPass;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CHECK")
    private Date dtCheck;

    @ManyToOne
    @JoinColumn(name = "COD_SERIAL")
    private GbrSerial fullSerial;

    @Override
    public String getDescription() {
        return "";
    }

}
