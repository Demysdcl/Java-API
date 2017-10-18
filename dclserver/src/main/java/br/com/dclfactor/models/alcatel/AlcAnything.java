/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models.alcatel;

import br.com.dclfactor.models.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALC_ANYTHING", schema = "db_accessadmin", catalog = "ALCATEL")
public class AlcAnything extends BaseEntity<Integer> {

    private static int ID_LENGHT = 9;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnything")
    private Integer id;

    @Getter
    @Setter
    private String keyValue;

    @Getter
    @Setter
    private Integer nextValue;

    @Getter
    @Setter
    private String description;

    public AlcAnything(String keyValue, Integer nextValue) {
        this.keyValue = keyValue;
        this.nextValue = nextValue;
    }

    public String getNextId() {
        int lenght = ID_LENGHT - keyValue.length();
        return keyValue + String.format("%0" + lenght + "d", nextValue);
    }

}
