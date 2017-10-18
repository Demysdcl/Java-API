package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_REPAIR_ACTION", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcAction extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "ID_ACTION")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "DESCRIPTION", length = 30)
    private String description;

    public AlcAction(Integer id) {
        this.id = id;
    }

}
