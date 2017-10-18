/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.observable.impl;

import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.repositories.LotRepository;
import br.com.dclfactor.service.impl.GenericObsServiceImpl;
import br.com.dclfactor.service.observable.LotObsService;
import io.reactivex.Observable;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LimaD01
 */
public class LotObsServiceImpl extends GenericObsServiceImpl<AlcLot, String>
        implements LotObsService {

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private LotRepository repository;

    @Override
    public Observable<AlcLot> getNextLot() {
        return Observable.fromCallable(() -> {
            return new AlcLot();
        });
    }

}
