/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repositories;

import br.com.dclfactor.models.alcatel.AlcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 */
public interface UserRepository extends JpaRepository<AlcUser, Integer>{
    
}
