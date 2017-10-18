/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.gbr.GbrLabelString;
import br.com.dclfactor.entity.gbr.GbrSku;
import br.com.dclfactor.repository.vo.PalleteZplVO;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface LabelStringRepository extends JpaRepository<GbrLabelString, Long> {

    @Query("SELECT new br.com.dclfactor.repository.vo.PalleteZplVO"
            + "(m.name, s.cor, s.ean, a.zpl) "
            + "FROM GbrLabelString a "
            + "INNER JOIN a.sku s "
            + "INNER JOIN s.model m "
            + "WHERE a.type = ?2 and s.sku = ?1")
    PalleteZplVO findBySku(String sku, String type);

}
