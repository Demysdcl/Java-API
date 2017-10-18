package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dclfactor.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_SYS_FLAG", schema = "db_accessadmin")
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class AlcFlag extends BaseEntity<String> {

    private static final long serialVersionUID = 170867269526000197L;

    private static int ID_LENGHT = 9;

    @Id
    @Column(name = "ID_FLAG", length = 30)
    @Getter
    @Setter
    private String id;

    @Column(name = "NEXT_VALUE", length = 50)
    @Getter
    @Setter
    private Integer nextValue;

    @Override
    public String getDescription() {
        return nextValue + "";
    }

    public String getNextLotId() {
        int lenght = ID_LENGHT - id.length();
        return id + String.format("%0" + lenght + "d", nextValue);
    }

}
