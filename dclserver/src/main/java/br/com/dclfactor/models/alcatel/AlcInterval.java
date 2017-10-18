package br.com.dclfactor.models.alcatel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.models.gbr.GbrLine;

@Getter
@Setter
@Entity
@Table(name = "ALC_INTERVAL", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcInterval extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_INTERVAL")
    private Integer id;

    @ManyToOne
    @NotNull(message = "Informe uma Linha")
    @JoinColumn(name = "COD_LINHA")
    private GbrLine line;

    @Column(name = "INTERVAL_HOUR")
    @NotNull(message = "Informe um Hor�rio")
    private Integer hour;

    @Column(name = "QTY_MINUTES")
    @NotNull(message = "Informe os minutos de Intervalo")
    private Integer minutes;

    @Override
    public String getDescription() {
        return "Linha: " + line.getDescription() + " Hora: " + hour
                + " minutos: " + minutes;
    }

    public Integer valueToDiscount(int target) {
        if (minutes == 60) {
            return target;
        }
        Double valuePerMinute = new Double(target) / 60.0;
        Double valueDiscount = valuePerMinute * new Double(minutes);
        return valueDiscount.intValue();
    }

}
