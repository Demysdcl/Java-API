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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_REPAIR_ACTION", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcAction extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_ACTION")
    private Integer id;

    @Column(name = "DESCRIPTION", length = 30)
    private String description;

    public AlcAction(Integer id) {
        this.id = id;
    }

}
