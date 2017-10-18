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

@Entity
@Table(name = "ALC_FAILURE", schema = "db_accessadmin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlcFailure extends BaseEntity<String> {

    private static final long serialVersionUID = 7913318567357814218L;

    @Id
    @Column(length = 5, name = "ID_FAILURE")
    private String id;

    @Column(length = 200, name = "DESCRIPTION")
    private String description;

}
