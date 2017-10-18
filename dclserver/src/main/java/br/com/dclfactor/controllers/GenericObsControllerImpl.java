/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.service.GenericObsService;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericObsControllerImpl<T extends BaseEntity<ID>, ID extends Serializable> {

    protected abstract GenericObsService<T, ID> getService();

    @GetMapping()
    public Observable<List<T>> findAll() {
        return getService().findAll();
    }

    @GetMapping("/{page}/{size}")
    public Observable<Page<T>> findAll(@PathVariable int page, @PathVariable int size) {
        return getService().findAll(page, size);
    }

    @GetMapping("/{id}")
    public Observable<T> findById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Observable<T> save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Observable<List<T>> save(@RequestBody Iterable<T> ts) {
        return getService().save(ts);
    }

    @GetMapping("/exists/{id}")
    public Observable<Boolean> exist(@PathVariable ID id) {
        return getService().exists(id);
    }
    
    @DeleteMapping("/{id}")
    public Observable<Boolean> delete(@PathVariable ID id) {
        return getService().delete(id);
    }

    @DeleteMapping
    public Observable<Boolean> delete(@RequestBody T entity) {
        return getService().delete(entity);
    }

    @DeleteMapping("/all")
    public Observable<Iterable<T>> delete(@RequestBody Iterable<T> ts) {
        return getService().delete(ts);
    }

}
