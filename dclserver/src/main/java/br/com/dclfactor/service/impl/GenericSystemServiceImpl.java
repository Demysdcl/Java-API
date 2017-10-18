package br.com.dclfactor.service.impl;

import br.com.dclfactor.models.SystemWrapper;
import io.reactivex.Single;
import static io.reactivex.Single.*;
import java.io.Serializable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dclfactor.service.GenericSystemService;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author LimaD01
 * @param <T>
 * @param <ID>
 */
public abstract class GenericSystemServiceImpl<T, ID extends Serializable>
        implements GenericSystemService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    protected abstract String getDescription();

    @Override
    public Single<SystemWrapper<List<T>>> findAll() {
        return defer(() -> {
            return just(SystemWrapper.wrapper(getDescription(),
                    getRepository().findAll()));
        });
    }

    @Override
    public Single<SystemWrapper<Page<T>>> findAll(int page, int size) {
        return defer(() -> {
            return just(SystemWrapper.wrapper(getDescription(),
                    getRepository().findAll(new PageRequest(page, size))));
        });
    }

    @Override
    public Single<SystemWrapper<T>> findById(ID id) {
        return defer(() -> {
            return just(new SystemWrapper<>(getDescription(),
                    getRepository().findOne(toUppercaseString(id))));
        });
    }
    
    public ID toUppercaseString(ID id){
        ID ajust = id;
        if(ajust.getClass().equals(String.class)){
            ajust = (ID) ajust.toString().toUpperCase();
        }
        return ajust;
    }

    @Override
    public Single<SystemWrapper<ID>> delete(ID id) {
        return defer(() -> {
            getRepository().delete(id);
            return just(SystemWrapper.wrapper(getDescription(), id));
        });
    }

    @Override
    public Single<SystemWrapper<Iterable<T>>> delete(Iterable<T> ts) {
        return defer(() -> {
            getRepository().delete(ts);
            return just(SystemWrapper.wrapper(getDescription(), ts));
        });
    }

    @Override
    public Single<SystemWrapper<T>> delete(T entity) {
        return defer(() -> {
            getRepository().delete(entity);
            return just(SystemWrapper.wrapper(getDescription(), entity));
        });
    }

    @Override
    public Single<SystemWrapper<List<T>>> save(Iterable<T> ts) {
        return defer(() -> {
            return just(SystemWrapper.wrapper(getDescription(),
                    getRepository().save(ts)));
        });
    }

    @Override
    public Single<SystemWrapper<T>> save(T entity) {
        return defer(() -> {
            return just(SystemWrapper.wrapper(getDescription() + " : new Created ",
                    getRepository().save(entity)));
        });
    }

}
