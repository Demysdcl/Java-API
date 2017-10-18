/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LimaD01
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable,
        Comparable<BaseEntity<ID>> {

    public abstract ID getId();

    public <T extends BaseEntity> T createEntity(Class<T> entity) {
        try {
            return entity.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int compareTo(BaseEntity<ID> o) {
        if (o == null || getId() == null) {
            return -1;
        }

        if (getId() instanceof Number) {
            Long out = ((Number) o.getId()).longValue();
            Long in = ((Number) getId()).longValue();
            return in.compareTo(out);
        }

        return o.getId().toString().compareTo(getId().toString());
    }

}
