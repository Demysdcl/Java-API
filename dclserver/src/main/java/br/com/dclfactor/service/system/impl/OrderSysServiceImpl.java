/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system.impl;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.service.impl.GenericSystemServiceImpl;
import br.com.dclfactor.models.alcatel.AlcOrder;
import br.com.dclfactor.repositories.OrderRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dclfactor.service.system.OrderSysService;
import io.reactivex.Single;
import java.util.List;

/**
 *
 * @author LimaD01
 */
@Service("orderObsService")
public class OrderSysServiceImpl extends GenericSystemServiceImpl<AlcOrder, String>
        implements OrderSysService {

    @Getter
    @Autowired
    private OrderRepository repository;

    @Override
    protected String getDescription() {
        return "Production Order";
    }

    @Override
    public Single<SystemWrapper<List<String>>> getOrderByLineAndSku(String line, String sku) {
        return Single.just(SystemWrapper.wrapper("Order de Produção", 
                repository.findOpsByLineAndSku(line, sku)));
    }

}
