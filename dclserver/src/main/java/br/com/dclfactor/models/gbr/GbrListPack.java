package br.com.dclfactor.models.gbr;

import java.math.BigDecimal;
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

@Entity
@Table(name = "GBR_LIST_PACK", schema = "dbo", catalog = "GBR")
@XmlRootElement
@Getter
@Setter
public class GbrListPack extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_LIST_PACK")
    private Integer id;

    @Column(name = "PACK_STRING")
    private String packString;

    @Column(name = "COD_SKU")
    private Integer codSku;

    @Column(name = "COD_MODELO")
    private Integer codModelo;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "COD_USUARIO")
    private Integer codUsuario;

    @Column(name = "FECHADO")
    private Boolean fechado;

    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "CONFERIDO_PACK")
    private Boolean conferidoPack;

    @Column(name = "IP")
    private String ip;

    @Column(name = "PESO")
    private BigDecimal peso;

    public GbrListPack() {
    }

    public GbrListPack(Integer codListPack) {
        this.id = codListPack;
    }   

    @Override
    public String getDescription() {
        return packString;
    }

}
