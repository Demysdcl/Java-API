/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

/**
 *
 * @author LimaD01
 */
import br.com.dclfactor.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_DEFECT", schema = "db_accessadmin", catalog = "ALCATEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlcDefect extends BaseEntity<String> {

    private static final long serialVersionUID = 392347291076797223L;

    @Id
    @Column(name = "COD_DEFECT", length = 10)
    private String id;

    @Column(length = 100, name = "DEFECT")
    private String description;

}
