/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.service.GenericSystemService;
import br.com.dclfactor.service.response.LotResponse;
import io.reactivex.Single;

/**
 *
 * @author LimaD01
 */
public interface LotSysService extends GenericSystemService<AlcLot, String>{
    
    public Single<SystemWrapper<AlcLot>> getLoteByOrder(String idOp);
    
}
