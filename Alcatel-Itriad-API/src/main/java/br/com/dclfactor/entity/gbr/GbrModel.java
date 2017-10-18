/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity.gbr;

import br.com.dclfactor.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GBR_CAD_MODELO", schema = "dbo", catalog = "GBR")
public class GbrModel extends BaseEntity<Long> {

    @Id
    @Getter
    @Setter
    @Column(name = "COD_MODELO")
    private Long id;

    @Getter
    @Setter
    @Column(name = "MODELO")
    private String name;

}
