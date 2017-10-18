package br.com.dclfactor.models.alcatel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALC_SYS_LOG", schema = "db_accessadmin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlcLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOG")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RESPONSIBLE")
    private AlcUser responsible;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_MAKED")
    private Date dtMaked;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SYS_LOG")
    private String log;

}
