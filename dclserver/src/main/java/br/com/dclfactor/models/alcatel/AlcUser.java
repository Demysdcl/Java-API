package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.dclfactor.models.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "ALC_SYS_USER", schema = "db_accessadmin")
public class AlcUser extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    @NotEmpty
    private String username;

    @Column(name = "USER_LOGIN", unique = true)
    @NotEmpty
    private String userLogin;

    @NotEmpty
    @Column(name = "userpassword")
    private String userPassword;

    @Column(name = "enable")
    private Boolean enabled;

    @Override
    public String getDescription() {
        return username;
    }

    public String getPassword() {
        return userPassword;
    }

    public boolean isItMe() {
        return username.toUpperCase().contains("DEMYS");
    }

}
