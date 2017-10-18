/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import io.reactivex.Observable;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;

public interface GenericObsService<T, ID extends Serializable> {

    Observable<T> findById(ID id);

    Observable<T> save(T entity);

    Observable<List<T>> save(Iterable<T> ts);

    Observable<Boolean> delete(T entity);
    
    Observable<Boolean> delete(ID id);

    Observable<Iterable<T>> delete(Iterable<T> ts);

    Observable<Boolean> exists(ID id);

    Observable<List<T>> findAll();
    
    Observable<Page<T>> findAll(int page, int size);

}
