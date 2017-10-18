/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcOrder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dclfactor.service.system.OrderSysService;
import io.reactivex.Single;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author LimaD01
 */
@RestController
@RequestMapping("/sys/ordem")
public class OrderSysController extends GenericSysControllerImpl<AlcOrder, String> {

    @Getter
    @Autowired
    private OrderSysService service;

    @GetMapping(path = "/findByLineAndSku/{line}/{sku}")
    public Single<SystemWrapper<List<String>>> findByLineAndSku(@PathVariable String line,
            @PathVariable String sku) {
        return service.getOrderByLineAndSku(line, sku);
    }

}
