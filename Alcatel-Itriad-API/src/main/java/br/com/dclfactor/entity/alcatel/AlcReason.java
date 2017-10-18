/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.alcatel;

import br.com.dclfactor.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ALC_REPAIR_REASON", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcReason extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_REASON")
    @Id
    private String id;

    @Column(name = "DESCRIPTION")
    private String description;

}
