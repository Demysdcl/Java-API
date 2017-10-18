package br.com.dclfactor.models.alcatel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REMESSA_VIEW", schema = "db_accessadmin")
public class RemessaView implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Size(max = 100)
    @Column(name = "REMESSA")
    private String remessa;

    @Getter
    @Setter
    @Size(max = 10)
    @Column(name = "PALLET_STRING")
    private String palletString;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "PACK_STRING")
    private String packString;

    @Getter
    @Setter
    @Size(max = 15)
    @Column(name = "IMEI_1")
    private String imei1;

}
