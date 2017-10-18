/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.gbr;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "GBR_CAD_MODELO", catalog = "GBR", schema = "dbo")
@XmlRootElement
@Getter
@Setter
public class GbrModel extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_MODELO")
    private Integer id;
    @Column(name = "SHORTCODE")
    private String shortcode;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANATEL")
    private String anatel;
    @Column(name = "NOME_MODELO")
    private String nomeModelo;

    public GbrModel() {
    }

    public GbrModel(Integer codModelo) {
        this.id = codModelo;
    }

    @Override
    public String getDescription() {
        return nomeModelo;
    }

}
