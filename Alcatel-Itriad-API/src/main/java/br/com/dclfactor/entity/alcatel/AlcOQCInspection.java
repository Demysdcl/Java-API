/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

import java.time.Duration;
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
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.dclfactor.entity.BaseEntity;
import br.com.dclfactor.entity.gbr.GbrLine;
import br.com.dclfactor.entity.gbr.GbrSerial;
import br.com.dclfactor.ui.DateUtil;

@Table(name = "ALC_OQC_INSPECTION", schema = "db_accessadmin")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class AlcOQCInspection extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    public static final String EM_ESPERA = "EM ESPERA";
    public static final String SEM_DEFEITO = "SEM DEFEITO";
    public static final String COM_DEFEITO = "COM DEFEITO";
    public static final String EXCLUIDO = "EXCLUÍDO";

    @Id
    @GeneratedValue
    @Column(name = "id_inspection")
    @Getter
    @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "oqc_operator")
    @Getter
    @Setter

    private AlcUser operator;

    @Column(length = 50)
    @NotNull(message = "Informe o SKU")
    @Getter
    @Setter
    private String sku;

    @Getter
    @Setter
    @Column(length = 10, name = "family")
    private String family;

    @Getter
    @Setter
    @Column(length = 20)
    private String status;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "line")
    @NotNull(message = "Informe a Linha")
    private GbrLine line;

    @Getter
    @Setter
    @Column(length = 50)
    private String box;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "product", unique = true)
    @NotNull(message = "Informe o IMEI")
    private GbrSerial product;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "defect")
    private AlcDefect defect;

    @Getter
    @Setter
    private String observation;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fintime")
    private Date finTime;

    @Getter
    @Setter
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public String getDuration() {
        if (creationDate != null && finTime != null) {
            Duration duration = Duration.between(creationDate.toInstant(),
                    finTime.toInstant());
            return DateUtil.formatDuration(duration.getSeconds());
        }
        return "";
    }

}
