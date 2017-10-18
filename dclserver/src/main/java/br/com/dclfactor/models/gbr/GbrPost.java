package br.com.dclfactor.models.gbr;

import br.com.dclfactor.models.BaseEntity;
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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_POSTOS", schema = "dbo", catalog = "GBR")

@XmlRootElement
public class GbrPost extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_POSTO")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "NOME")
    private String nome;

    @Getter
    @Setter
    @Column(name = "CAMINHO_SAV")
    private String caminhoSav;

    @Getter
    @Setter
    @Column(name = "CAMINHO_BACKUP")
    private String caminhoBackup;

    @Getter
    @Setter
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Getter
    @Setter
    @Column(name = "DESATIVADO")
    private Boolean desativado;
    @Getter
    @Setter
    @Column(name = "METODO2")
    private Boolean metodo2;

    public GbrPost() {
    }

    public GbrPost(Integer codPosto) {
        this.id = codPosto;
    }

    @Override
    public String getDescription() {
        return nome;
    }

}
