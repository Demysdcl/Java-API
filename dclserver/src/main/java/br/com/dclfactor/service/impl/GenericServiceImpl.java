/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.impl;

import br.com.dclfactor.models.BaseEntity;
import java.io.Serializable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dclfactor.service.GenericService;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericServiceImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements GenericService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Page<T> findAll(int page, int size) {
        return getRepository().findAll(new PageRequest(page, size));
    }

    @Override
    public T findById(ID id) {
        return  getRepository().findOne(id);
    }

    @Override
    public boolean exists(ID id) {
        return findById(id) != null;
    }

    @Override
    public boolean delete(ID id) {
        getRepository().delete(id);
        return exists(id);
    }

    @Override
    public Iterable<T> delete(Iterable<T> ts) {
        getRepository().delete(ts);
        return ts;
    }

    @Override
    public boolean delete(T entity) {
        ID id = entity != null ? entity.getId() : null;
        getRepository().delete(entity);
        return exists(id);
    }

    @Override
    public List<T> save(Iterable<T> ts) {
        return getRepository().save(ts);
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

}
