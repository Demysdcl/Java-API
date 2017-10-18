/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

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
    @Column(name = "idpost")
    private Integer id;

    private String description;

}
