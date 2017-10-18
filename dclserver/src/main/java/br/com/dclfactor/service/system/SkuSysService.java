/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrSku;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;
import java.util.List;

/**
 *
 * @author LimaD01
 */
public interface SkuSysService extends GenericSystemService<GbrSku, Integer>{
    
    Single<SystemWrapper<List<String>>> findSkuName();
    
}
