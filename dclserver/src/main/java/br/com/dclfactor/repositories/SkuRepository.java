/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repositories;

import br.com.dclfactor.models.gbr.GbrSku;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author LimaD01
 */
@RepositoryRestResource(path = "sku")
public interface SkuRepository extends JpaRepository<GbrSku, Integer>{
    
//    @RestResource(path = "findByCustumer", rel = "cliente")
    List<SkuRepository> findByCliente(@Param("cliente") String cliente);

    @Query("Select a.sku from GbrSku a order by a.sku")
    List<String> findAllSku();    
    
}
