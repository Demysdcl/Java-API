/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Table(name = "ALC_PPB", schema = "db_accessadmin")
@Getter
@Setter
@XmlRootElement
public class AlcPpb extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ppb")
    private String id;

    @Column(name = "BATTERY")
    private Boolean battery;
    @Column(name = "CHARGER")
    private Boolean charger;
    @Column(name = "MEMORY")
    private Boolean memory;
    @Column(name = "SD_CARD")
    private Boolean sdCard;

    public AlcPpb() {
    }

    public AlcPpb(String id) {
        this.id = id;
    }

}
