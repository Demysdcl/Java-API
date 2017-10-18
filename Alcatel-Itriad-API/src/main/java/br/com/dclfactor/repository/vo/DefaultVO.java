/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository.vo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
@NoArgsConstructor
@AllArgsConstructor
public class DefaultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
    @Setter
    private Object name;

    @Getter
    @Setter
    private Number value;

}
