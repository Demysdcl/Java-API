/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrListPack;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;

/**
 *
 * @author LimaD01
 */
public interface ListPackSysService extends GenericSystemService<GbrListPack, Integer>{
 
    Single<SystemWrapper<GbrListPack>> findByPack(String packString);
    
}
