package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_DEPARTMENT", schema = "db_accessadmin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class AlcDepartment extends BaseEntity<Integer> {

    private static final long serialVersionUID = -7824437996191956983L;

    @Id
    @GeneratedValue
    @Column(name = "ID_DEPARTMENT")
    private Integer id;

    @Column(name = "DESCRIPTION")
    private String description;

}
