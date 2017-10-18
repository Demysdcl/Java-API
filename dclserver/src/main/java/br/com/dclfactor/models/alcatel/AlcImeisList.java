package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ALC_LIST_ORDER", schema = "db_accessadmin", catalog = "ALCATEL")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AlcImeisList extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 15)
    private String id;

    @Column(length = 30)
    private String fullsku;

    @Column(length = 15)
    private String packing;

    @Column(length = 15)
    private String lot;

    @Column(name = "codorder", length = 30)
    private String codOrder;

    @Column(length = 15)
    private String pallet;

    private String shipping;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return "";
    }

}
