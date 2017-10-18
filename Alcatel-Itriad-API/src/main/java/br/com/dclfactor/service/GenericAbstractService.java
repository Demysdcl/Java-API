/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericAbstractService<T, ID extends Serializable> implements Serializable {

    protected abstract JpaRepository<T, ID> getRepository();

    public T findById(ID id) {
        return getRepository().findOne(id);
    }
  
    public List<T> findAll() {
        return getRepository().findAll();
    }
    
    public Page<T> findAll(Pageable pageable){
        return getRepository().findAll(pageable);
    }

}
