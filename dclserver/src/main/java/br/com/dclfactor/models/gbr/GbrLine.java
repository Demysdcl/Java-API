/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.gbr;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_LINHAS", schema = "dbo", catalog = "GBR")
@XmlRootElement
@Getter
@Setter
public class GbrLine extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_LINHAS")
    private Integer id;

    @Column(name = "NOME_LINHA")
    private String description;

    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLine;

    public GbrLine() {
    }

    public GbrLine(Integer id) {
        this.id = id;
    }

}
