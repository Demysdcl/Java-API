/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcOrder;
import java.io.Serializable;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;
import java.util.List;

/**
 *
 * @author LimaD01
 */
public interface OrderSysService extends GenericSystemService<AlcOrder, String>{
    public Single<SystemWrapper<List<String>>> getOrderByLineAndSku(String line, String sku);
}
