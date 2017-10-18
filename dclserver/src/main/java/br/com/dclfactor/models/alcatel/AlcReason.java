package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_REPAIR_REASON", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcReason extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_REASON")
    @Id
    private String id;

    @Column(name = "DESCRIPTION")
    private String description;

}
