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
@Table(name = "GBR_CAD_SMT_SERIAL", schema = "dbo", catalog = "GBR")
@Getter
@Setter
@XmlRootElement
public class GbrSerial extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SMT")
    private Integer id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "COD_SKU")
    private Integer codSku;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "COD_MODELO")
    private Integer codModelo;

    @Column(name = "VERIFICADO")
    private Boolean verificado;

    @Column(name = "DEBUG_SAV")
    private Boolean debugSav;

    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "INSPECAO_USER")
    private String inspecaoUser;

    @Column(name = "INSPECAO_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inspecaoData;

    @Column(name = "INSPECAO_VERIFICADO")
    private Boolean inspecaoVerificado;

    @Column(name = "INSPECAO_SESSAO")
    private Integer inspecaoSessao;

    @Column(name = "IMEI_RECEBIDO")
    private Boolean imeiRecebido;

    @Column(name = "CAXA_COLETIVA")
    private Boolean coletiva;

    @Column(name = "CAIXA_INDIVIDUAL")
    private Boolean individual;

    @Column(name = "PALLETIZADO")
    private Boolean palletizado;

    @Column(name = "IMEI_1")
    private String imei1;

    @Column(name = "IMEI_2")
    private String imei2;

    @Column(name = "IMEI_3")
    private String imei3;

    @Column(name = "IMEI_4")
    private String imei4;

    @Column(name = "COD_LINHA")
    private Integer codLinha;

    @Column(name = "PACKSTRING")
    private String packstring;

    @Column(name = "PALLETSTRING")
    private String palletstring;

    @Column(name = "COD_LINHA_IMEI")
    private Integer codLinhaImei;

    @Column(name = "COD_LINHA_INDIVIDUAL")
    private Integer codLinhaIndividual;

    @Column(name = "COD_LINHA_COLETIVA")
    private Integer codLinhaColetiva;

    @Column(name = "COD_LINHA_PALLET")
    private Integer codLinhaPallet;

    @Column(name = "COD_LINHA_FT")
    private Integer codLinhaFt;

    @Column(name = "COMPUTER_NAME")
    private String computerName;

    @Column(name = "DATA_LINHA_IMEI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLinhaImei;

    @Column(name = "DATA_LINHA_FT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLinhaFt;

    @Column(name = "DATA_LINHA_INDIVIDUAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataIndividual;

    @Column(name = "DATA_LINHA_COLETIVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLinhaColetiva;

    @Column(name = "DATA_LINHA_PALLET")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLinhaPallet;

    @Column(name = "SERIAL_ENGINES")
    private Boolean serialEngines;

    @Column(name = "ENGINES_EXPORTADO_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enginesExportadoData;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private BigDecimal peso;

    @Column(name = "COD_VOLUME", length = 25)
    private String volume;

    @Column(name = "ORDEM", length = 15)
    private String ordem;

    public GbrSerial() {
    }

    public GbrSerial(Integer codSmt) {
        this.id = codSmt;
    }

    @Override
    public String getDescription() {
        return serial;
    }

}
