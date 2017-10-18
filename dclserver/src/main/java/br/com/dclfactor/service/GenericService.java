/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.models.BaseEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public interface GenericService< T extends BaseEntity<ID>, ID extends Serializable> extends Serializable {

    List<T> findAll();

    Page<T> findAll(int page, int size);

    T findById(ID id);

    T save(T entity);

    boolean exists(ID id);

    Iterable<T> save(Iterable<T> ts);

    Iterable<T> delete(Iterable<T> ts);

    boolean delete(T entity);

    boolean delete(ID id);

}
