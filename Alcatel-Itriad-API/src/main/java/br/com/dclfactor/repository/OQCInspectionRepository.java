/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.alcatel.AlcOQCInspection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 */
public interface OQCInspectionRepository extends JpaRepository<AlcOQCInspection, Integer>{
    
    List<AlcOQCInspection> findByCreationDateBetween(Date iniDate, Date finDate);
    
}
