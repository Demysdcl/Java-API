package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALC_PPB_TARGET", schema = "db_accessadmin")
public class AlcPPBTarget extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "TARGET_ID")
    private Long id;

    @Column(name = "MATERIAL")
    @NotNull(message = "Informe o Tipo de Material")
    private String description;

    @Column(name = "TARGET_YEAR")
    @NotNull(message = "Informe o Ano")
    private Integer year;

    @Column(name = "TARGET")
    private Double target;

}
