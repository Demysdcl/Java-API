/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.system;

import br.com.dclfactor.models.SystemWrapper;
import br.com.dclfactor.models.gbr.GbrLine;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dclfactor.service.GenericSystemService;
import io.reactivex.Single;
import java.util.List;

/**
 *
 * @author LimaD01
 */
public interface LineSysService extends GenericSystemService<GbrLine, Integer> {

    public Single<SystemWrapper<List<String>>> findLineNames();
    
}
