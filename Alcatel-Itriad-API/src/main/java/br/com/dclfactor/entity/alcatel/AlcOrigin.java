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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ALC_REPAIR_ORIGIN", schema = "db_accessadmin")
public class AlcOrigin extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_ORIGIN")
    private Integer id;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

}
