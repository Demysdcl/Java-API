/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.AlcListProduction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 */
public interface ProductionRepository extends JpaRepository<AlcListProduction, Long>{
    
    List<AlcListProduction> findByLote(String lote);
    
}
