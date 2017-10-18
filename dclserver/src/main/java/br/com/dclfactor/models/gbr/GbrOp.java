package br.com.dclfactor.models.gbr;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_OP", schema = "dbo", catalog = "GBR")
@XmlRootElement
@Getter
@Setter
public class GbrOp extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_OP")
    private Integer id;
    @Column(name = "OP")
    private String op;
    @Column(name = "COD_SKU")
    private Integer codSku;
    @Column(name = "DATA_ABERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAbertura;
    @Column(name = "DATA_FECHAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFechamento;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Column(name = "FORCADO")
    private Boolean forcado;
    @Column(name = "NO_MAXIMO_SERIAL")
    private Integer noMaximoSerial;
    @Column(name = "SERIAL_ENGINES")
    private Boolean serialEngines;

    public GbrOp() {
    }

    public GbrOp(Integer codOp) {
        this.id = codOp;
    }


    @Override
    public String getDescription() {
        return op;
    }

}
