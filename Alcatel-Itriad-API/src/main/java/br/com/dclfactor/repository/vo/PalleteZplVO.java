/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository.vo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author LimaD01
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PalleteZplVO implements Serializable{
    
    private String model;
    private String color;
    private String ean;
    private String zplCode;
    
}
