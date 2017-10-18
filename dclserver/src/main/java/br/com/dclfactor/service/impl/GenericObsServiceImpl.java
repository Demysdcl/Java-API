/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.impl;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.service.GenericObsService;
import io.reactivex.Observable;
import static io.reactivex.Observable.*;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericObsServiceImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements GenericObsService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public Observable<T> findById(ID id) {
        return defer(() -> {
            T found = getRepository().findOne(id);
            if (found != null) {
                return just(found);
            }
            return empty();
        });
       
    }

    @Override
    public Observable<T> save(T entity) {
        return fromCallable(() -> {
            return getRepository().save(entity);
        });
    }

    @Override
    public Observable<List<T>> save(Iterable<T> ts) {
        return fromCallable(() -> {
            return getRepository().save(ts);
        });
    }

    @Override
    public Observable<Boolean> delete(T entity) {
        return defer(() -> {
            if (entity != null) {
                return delete(entity.getId());
            }
            return just(false);
        });
    }

    @Override
    public Observable<Boolean> delete(ID id) {
        return defer(() -> {
            getRepository().delete(id);
            return exists(id).map(res -> !res);
        });
    }

    @Override
    public Observable<Iterable<T>> delete(Iterable<T> ts) {
        return defer(() -> {
            getRepository().delete(ts);
            return just(ts);
        });
    }

    @Override
    public Observable<Boolean> exists(ID id) {
        return defer(() -> {
            return findById(id).to(result -> {
                return just(!result.isEmpty().blockingGet());
            });
            
        });
    }

    @Override
    public Observable<List<T>> findAll() {
        return fromCallable(() -> {
            return getRepository().findAll();
        });
    }

    @Override
    public Observable<Page<T>> findAll(int page, int size) {
        return fromCallable(() -> {
            return getRepository().findAll(new PageRequest(page, size));
        });
    }

}
