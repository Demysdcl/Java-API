/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.service.GenericService;
import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericControllerImpl<T extends BaseEntity<ID>, ID extends Serializable> {

    protected abstract GenericService<T, ID> getService();

    @GetMapping()
    public @ResponseBody
    List<T> findAll() {
        return getService().findAll();
    }

    @GetMapping("/{page}/{size}")
    public @ResponseBody
    Page<T> findAll(@PathVariable int page, @PathVariable int size) {
        return getService().findAll(page, size);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    T findById(@PathVariable ID id) {
        return getService().findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Iterable<T> save(@RequestBody Iterable<T> ts) {
        return getService().save(ts);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    boolean delete(@PathVariable ID id) {
        return getService().delete(id);
    }

    @DeleteMapping
    public @ResponseBody
    boolean delete(@RequestBody T entity) {
        return getService().delete(entity);
    }

    @DeleteMapping("/all")
    public @ResponseBody
    Iterable<T> delete(@RequestBody Iterable<T> ts) {
        return getService().delete(ts);
    }

}
