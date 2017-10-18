/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class SystemWrapper<T> implements Serializable {

    @Getter
    @Setter
    private String description;

    private T value;
    
    @Getter
    private String msg;

    public SystemWrapper(String description, T value) {
        this.description = description;
        this.value = value;
    }
    
    public static <V> SystemWrapper<V> wrapper(String description, V value) {
        return new SystemWrapper(description, value);
    }

    public static SystemWrapper<String> errorWrapper(String description) {
        return SystemWrapper.wrapper("System Error module: " + description, " An internal error was thrown");
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
