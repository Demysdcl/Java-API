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

@Entity
@Table(name = "ALC_POST_USER", schema = "db_accessadmin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlcPost extends BaseEntity<Integer> {

    private static final long serialVersionUID = -7516951142351939700L;

    @Id
    @GeneratedValue
    @Column(name = "idPost")
    private Integer id;

    private String description;

}
