/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.entity.gbr.GbrSerial;
import br.com.dclfactor.repository.SerialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service
public class SerialService {
    
    @Autowired
    private SerialRepository repository;
    
    public boolean exists(String imei){
    	return repository.findByImei1(imei) != null;
    }
    
    public GbrSerial findByCode(String code){
        return repository.findByCode(code);
    }
    
}
