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
@Getter
@Setter
@Table(name = "ALC_PPB", schema = "db_accessadmin")
@NoArgsConstructor
@AllArgsConstructor
public class AlcPPB extends BaseEntity<String> {

    private static final long serialVersionUID = 595288291841359412L;
    @Id
    @Column(length = 5)
    private String ppb;

    @Column(name = "BATTERY")
    private Boolean battery;

    @Column(name = "CHARGER")
    private Boolean charger;

    @Column(name = "MEMORY")
    private Boolean memory;

    @Column(name = "SD_CARD")
    private Boolean sdCard;

    public AlcPPB(String ppb) {
        this.ppb = ppb;
    }

    @Override
    public String getId() {
        return ppb;
    }
}
