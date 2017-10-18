package br.com.dclfactor.models.gbr;

import java.io.Serializable;
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

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_LIST_PALLET", schema = "dbo", catalog = "GBR")
@XmlRootElement
@Getter
@Setter
public class GbrListPallet extends BaseEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_LIST_PALLET")
    private Integer id;
    @Column(name = "PACK_STRING")
    private String packString;
    @Column(name = "PALLET_STRING")
    private String palletString;
    @Column(name = "COD_OP")
    private Integer codOp;
    @Column(name = "COD_SKU")
    private Integer codSku;
    @Column(name = "COD_MODELO")
    private Integer codModelo;
    @Column(name = "COD_USUARIO")
    private Integer codUsuario;
    @Column(name = "FECHADO")
    private Boolean fechado;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "ETIQUETA_VALIDADA")
    private Boolean etiquetaValidada;
    @Column(name = "ETIQUETA_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etiquetaData;
    @Column(name = "CQ_VALIDADA")
    private Boolean cqValidada;
    @Column(name = "PESO")
    private BigDecimal peso;

    @Override
    public String getDescription() {
        return palletString;
    }

}
