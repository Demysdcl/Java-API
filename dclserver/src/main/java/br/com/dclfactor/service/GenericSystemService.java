/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service;

import br.com.dclfactor.models.SystemWrapper;
import io.reactivex.Single;
import io.reactivex.Single;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public interface GenericSystemService<T, ID extends Serializable> extends Serializable {

    Single<SystemWrapper<List<T>>> findAll();

    Single<SystemWrapper<Page<T>>> findAll(int page, int size);
    
    Single<SystemWrapper<T>> findById(ID id);

    Single<SystemWrapper<T>> save(T entity);

    Single<SystemWrapper<List<T>>> save(Iterable<T> ts);

    Single<SystemWrapper<Iterable<T>>> delete(Iterable<T> ts);

    Single<SystemWrapper<T>> delete(T entity);

    Single<SystemWrapper<ID>> delete(ID id);

}
