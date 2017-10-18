/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.FullProductView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 *
 * @author LimaD01
 */
public interface FullProductRepository extends JpaRepository<FullProductView, Long> {
    
    List<FullProductView> findByGrp(String GRP);

}
