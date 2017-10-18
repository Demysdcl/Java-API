package br.com.dclfactor.models.alcatel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@XmlRootElement
@Table(name = "ALC_HDT_PROD", schema = "db_accessadmin")
public class AlcHDT implements Serializable {

    @Id
    @Column(name = "HDT_NAME")
    @Getter
    @Setter
    private String id;

    @Column(name = "BEGIN_RANGE")
    @Getter
    @Setter
    private String beginRange;

    @Column(name = "END_RANGE")
    @Getter
    @Setter
    private String endRange;

    @Column(name = "CURRENT_RANGE")
    @Getter
    @Setter
    private String currentRange;

    @Transient
    public long getDiff() {
        long end = Long.parseLong(endRange);
        long current = Long.parseLong(currentRange);
        if (end == 0) {
            return 0;
        }
        return end - current;
    }

    @Override
    public String toString() {
        return id + " " + beginRange + " " + currentRange + " " + endRange;
    }

}
