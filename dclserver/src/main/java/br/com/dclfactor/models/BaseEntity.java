
package br.com.dclfactor.models;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.NoArgsConstructor;

/**
 *
 * @author LimaD01
 * @param <ID>
 */
@NoArgsConstructor
public abstract class BaseEntity<ID extends Serializable> implements
        Serializable, Comparable<BaseEntity<ID>> {

    public abstract ID getId();

    
    
    public String getDescription(){
        return "";
    };

    @Override
    public String toString() {
        return getId() + " " + getDescription();
    }
    
    public <T extends BaseEntity> T createEntity(Class<T> entity){
        try {
            return entity.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
//      @Override
//    public boolean equals(Object obj) {
//        if (obj == null || getId() == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        return getId().equals(((BaseEntity<ID>) obj).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getId().hashCode();
//    }

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
