package br.com.dclfactor.models.alcatel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@XmlRootElement
@Table(name = "ALC_HOUR_SHIFT", schema = "db_accessadmin")
public class AlcHourShift implements Serializable {

    @Column(name = "SEQ")
    private Integer seq;

    @Column(name = "HOUR")
    private Integer hour;

    @Column(name = "TARGET")
    private Integer target;

}
