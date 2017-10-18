/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.gbr.GbrSerial;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface SerialRepository extends JpaRepository<GbrSerial, Long>{

    public GbrSerial findByImei1(String imei);

    @Query("Select a From GbrSerial a Where a.serial = ?1 or a.imei1 = ?1")
	public GbrSerial findByCode(String code);
    
}
