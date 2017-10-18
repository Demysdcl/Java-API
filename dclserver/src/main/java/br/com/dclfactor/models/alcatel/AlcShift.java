package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.dclfactor.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ALC_SHIFT", schema = "db_accessadmin")
@Getter
@Setter
public class AlcShift extends BaseEntity<Integer> {

    private static final long serialVersionUID = -8129283297172226842L;

    @Id
    @GeneratedValue
    @Column(name = "ID_SHIFT")
    private Integer id;

    @NotNull(message = "Informe a descricao do turno")
    @Column(name = "DESCRIPTION", length = 30)
    private String description;

//	@Column(name = "HOUR_INICIAL")
//	private Integer hourIni;
//
//	@Column(name = "MIN_INI")
//	private Integer minIni;
//
//	@Column(name = "HOUR_FINAL")
//	private Integer hourFin;
//
//	@Column(name = "MIN_FINAL")
//	private Integer minFin;
}
