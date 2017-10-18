/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.alcatel.AlcUser;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dclfactor.service.system.UserSysService;

@RestController
@RequestMapping("/sys/user")
public class UserSysController extends GenericSysControllerImpl<AlcUser, Integer>{
    
    @Getter(AccessLevel.PROTECTED)
    @Autowired
    private UserSysService service;
    
}
