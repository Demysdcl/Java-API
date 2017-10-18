/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.entity;

import br.com.dclfactor.repository.vo.CountProductionVO;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
public class GroupProductionAndData implements Serializable{

    @Getter
    @Setter
    private List<CountProductionVO> production;

    @Getter
    @Setter
    private List<?> data;

}
