/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repositories;

import br.com.dclfactor.models.alcatel.AlcLot;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface LotRepository extends JpaRepository<AlcLot, String>{

    @Query("Select a from AlcLot a where op.id = ?1 and status = 'ATIVO' order by a.id ")
    public List<AlcLot> findOneActivatedByOp(String id);
    
}
