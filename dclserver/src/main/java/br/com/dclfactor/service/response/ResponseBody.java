/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.response;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
public class ResponseBody implements Serializable{
    
    @Getter
    @Setter
    private String msg;

    public ResponseBody(String msg) {
        this.msg = msg;
    }
    
}
