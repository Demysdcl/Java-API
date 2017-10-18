/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.ListProdResponse;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcListProduction;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;

/**
 *
 * @author LimaD01
 */
public interface ListProdSysService extends GenericSystemService<AlcListProduction, Integer> {
    
    public Single<SystemWrapper<ListProdResponse>>  processProduction(String lotId, String box);
    
}
