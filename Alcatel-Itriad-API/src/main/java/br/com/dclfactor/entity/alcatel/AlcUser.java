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
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "ALC_SYS_USER", schema = "db_accessadmin")
public class AlcUser extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    private Integer id;

    @NotEmpty
    @Column(name = "USER_NAME")
    private String username;

}
