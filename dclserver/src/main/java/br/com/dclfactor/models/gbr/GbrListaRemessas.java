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
@Table(name = "GBR_LISTA_REMESSAS", schema = "dbo", catalog = "GBR")
@XmlRootElement
@Getter
@Setter
public class GbrListaRemessas extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_REMESSA")
    private Integer id;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "REMESSA")
    private String remessa;
    @Column(name = "IMEI")
    private String imei;
    @Column(name = "CODVENDA")
    private String codvenda;
    @Column(name = "QTY")
    private Integer qty;
    @Column(name = "FILE_PATH")
    private String filePath;

    @Override
    public String getDescription() {
        return remessa;
    }

}
