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
@Table(name = "GBR_CAD_SKU", schema = "dbo", catalog = "GBR")

@XmlRootElement
public class GbrSku extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SKU")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "SKU")
    @Getter
    @Setter
    private String sku;

    @Getter
    @Setter
    @Column(name = "COD_MODELO")
    private Integer codModelo;

    @Getter
    @Setter
    @Column(name = "CLIENTE")
    private String cliente;

    @Getter
    @Setter
    @Column(name = "COR")
    private String cor;

    @Getter
    @Setter
    @Column(name = "SAPCODE")
    private String sapcode;

    @Getter
    @Setter
    @Column(name = "EAN")
    private String ean;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "PACK_STRING")
    private String packString;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "PALLET_STRING")
    private String palletString;

    @Getter
    @Setter
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO_MIN")
    private BigDecimal pesoMin;

    @Getter
    @Setter
    @Column(name = "PESO_MAX")
    private BigDecimal pesoMax;

    @Getter
    @Setter
    @Column(name = "PESO_ATIVO")
    private Boolean pesoAtivo;

    @Getter
    @Setter
    @Column(name = "TIME_OUT")
    private Integer timeOut;

    @Getter
    @Setter
    @Column(name = "PESO_MAX_COLETIVO")
    private BigDecimal pesoMaxColetivo;

    @Getter
    @Setter
    @Column(name = "PESO_MIN_COLETIVO")
    private BigDecimal pesoMinColetivo;

    @Getter
    @Setter
    @Column(name = "PESO_COLETIVO_ATIVO")
    private Boolean pesoColetivoAtivo;

    @Getter
    @Setter
    @Column(name = "CONFIRMAR_CAMPOS_ADICIONAIS")
    private Boolean confirmarCamposAdicionais;

    @Getter
    @Setter
    @Column(name = "CONFIRMAR_2D_CX_COL")
    private Boolean confirmar2dCxCol;

    @Getter
    @Setter
    @Column(name = "PRODUCTCODES")
    private String productcodes;

    @Getter
    @Setter
    @Column(name = "IMPORTATION_LABEL")
    private String importationLabel;

    @Getter
    @Setter
    @Column(name = "QTD_PRODUTO_COLETIVO")
    private Integer qtdProdutoColetivo;

    @Getter
    @Setter
    @Column(name = "QTD_PRODUTO_PALLET")
    private Integer qtdProdutoPallet;

    @Getter
    @Setter
    @Column(name = "ATIVO")
    private Boolean ativo;

    @Getter
    @Setter
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Getter
    @Setter
    @Column(name = "BALANCA_RAPIDA")
    private Boolean balancaRapida;

    @Getter
    @Setter
    @Column(name = "PATH_SAP_FILE_COLETIVA")
    private String pathSapFileColetiva;

    @Getter
    @Setter
    @Column(name = "PATH_SAP_FILE_PALLET")
    private String pathSapFilePallet;

    @Getter
    @Setter
    @Column(name = "QTD_COLMEIA")
    private Integer qtdColmeia;

    @Getter
    @Setter
    @Column(name = "PATH_COLMEIA")
    private String pathColmeia;

    @Getter
    @Setter
    @Column(name = "TOTAL_COLMEIA")
    private Integer totalColmeia;

    @Getter
    @Setter
    @Column(name = "PCBA")
    private String pcba;

    @Getter
    @Setter
    @Column(name = "BOM")
    private String bom;

    @Getter
    @Setter
    @Column(name = "QTD_CHECK_CQ")
    private Integer qtdCheckCq;

    @Getter
    @Setter
    @Column(name = "CHK_CQ_PALLET")
    private Boolean chkCqPallet;

    @Getter
    @Setter
    @Column(name = "CONFIRMAR_IMEI_PALLET")
    private Boolean confirmarImeiPallet;

    @Getter
    @Setter
    @Column(name = "CHK_SERIAL_CX_INDIVIDUAL")
    private Boolean chkSerialCxIndividual;

    @Getter
    @Setter
    @Column(name = "DELAY_CX_INDIVIDUAL")
    private Integer delayCxIndividual;

    @Getter
    @Setter
    @Column(name = "CHK_IMEI_AP_COLETIVA")
    private Boolean chkImeiApColetiva;

    @Getter
    @Setter
    @Column(name = "QTD_PRODUTO_VOLUME")
    private Integer qtdProdutoVolume;

    @Getter
    @Setter
    @Column(name = "PATH_SAP_FILE_VOLUME")
    private String pathSapFileVolume;

    @Getter
    @Setter
    @Column(name = "VOLUME_STRING")
    private String volumeString;

    public GbrSku() {
    }

    public GbrSku(Integer codSku) {
        this.id = codSku;
    }

    public GbrSku(Integer codSku, String packString, String palletString) {
        this.id = codSku;
        this.packString = packString;
        this.palletString = palletString;
    }

    @Override
    public String getDescription() {
        return sku;
    }

}
