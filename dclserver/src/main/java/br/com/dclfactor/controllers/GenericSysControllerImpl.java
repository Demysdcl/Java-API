/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers;

import br.com.dclfactor.models.SystemWrapper;
import io.reactivex.Single;
import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.dclfactor.service.GenericSystemService;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericSysControllerImpl<T, ID extends Serializable> {

    protected abstract GenericSystemService<T, ID> getService();

    @GetMapping()
    public @ResponseBody
    Single<SystemWrapper<List<T>>> findAll() {
        return getService().findAll();
    }

    @GetMapping("/{page}/{size}")
    public @ResponseBody
    Single<SystemWrapper<Page<T>>> findAll(@PathVariable int page, @PathVariable int size) {
        return getService().findAll(page, size);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Single<SystemWrapper<T>> findById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Single<SystemWrapper<T>> save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Single<SystemWrapper<List<T>>> save(@RequestBody Iterable<T> ts) {
        return getService().save(ts);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    Single<SystemWrapper<ID>> delete(@PathVariable ID id) {
        return getService().delete(id);
    }

    @DeleteMapping
    public @ResponseBody
    Single<SystemWrapper<T>> delete(@RequestBody T entity) {
        return getService().delete(entity);
    }

    @DeleteMapping("/all")
    public @ResponseBody
    Single<SystemWrapper<Iterable<T>>> delete(@RequestBody Iterable<T> ts) {
        return getService().delete(ts);
    }

}
