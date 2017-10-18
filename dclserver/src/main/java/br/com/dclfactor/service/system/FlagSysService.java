/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.alcatel.AlcFlag;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;

/**
 *
 * @author LimaD01
 */
public interface FlagSysService extends GenericSystemService<AlcFlag, String> {

    Single<SystemWrapper<AlcFlag>> getNextLotKey(String keyValue);

}
