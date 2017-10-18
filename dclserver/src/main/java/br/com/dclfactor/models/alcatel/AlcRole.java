package br.com.dclfactor.models.alcatel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_ROLE_USER", schema = "db_accessadmin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlcRole extends BaseEntity<String> implements GrantedAuthority {

    public static final String PLANNING = "PLANNING";
    public static final String ADMIN = "ADMIN";
    public static final String LEADER = "LEADER";
    public static final String DISPATCHER = "DISPATCHER";
    public static final String TEC = "TEC";

    private static final long serialVersionUID = 1L;
    @Id
    @NotEmpty
    private String authority;

    @Override
    public String getId() {
        return authority;
    }

}
