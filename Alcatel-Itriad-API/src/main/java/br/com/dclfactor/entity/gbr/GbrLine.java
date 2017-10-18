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

/**
 *
 * @author LimaD01
 */
@Entity

@Table(name = "GBR_CAD_LINHAS", schema = "dbo", catalog = "GBR")
public class GbrLine extends BaseEntity<Long> {

    @Id
    @Column(name = "COD_LINHAS")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "NOME_LINHA")
    private String name;

}
