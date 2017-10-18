/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.observable;

import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.service.GenericObsService;
import io.reactivex.Observable;

/**
 *
 * @author LimaD01
 */
public interface LotObsService extends GenericObsService<AlcLot, String >{
    
    public Observable<AlcLot> getNextLot();
    
}
