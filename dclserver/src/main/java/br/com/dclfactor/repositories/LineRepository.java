/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repositories;

import br.com.dclfactor.models.gbr.GbrLine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface LineRepository extends JpaRepository<GbrLine, Integer>{

    @Query("SELECT a.description from GbrLine a")
    public List<String> findAllLines();
    
}
