/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repositories;

import br.com.dclfactor.models.alcatel.AlcOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface OrderRepository extends JpaRepository<AlcOrder, String>{
    
    @Query("SELECT a.id FROM AlcOrder a "
            + "INNER JOIN a.sku s "
            + "INNER JOIN a.line l "
            + "WHERE l.description = ?1 and s.sku = ?2 "
            + "and a.status = 'ATIVO'")
    List<String> findOpsByLineAndSku(String line, String sku);
    
}
