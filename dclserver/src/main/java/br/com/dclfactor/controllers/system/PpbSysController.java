/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers.system;

import br.com.dclfactor.controllers.GenericControllerImpl;
import br.com.dclfactor.controllers.GenericSysControllerImpl;
import br.com.dclfactor.models.alcatel.AlcPpb;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.dclfactor.service.system.PpbSysService;

@RestController
@RequestMapping("/sys/ppb")
public class PpbSysController extends GenericSysControllerImpl<
        AlcPpb, String>{

   @Autowired
   @Getter(AccessLevel.PROTECTED)
   private PpbSysService service;
//
//    @Override
//    @GetMapping
//    public Observable<SystemWrapper> findAll() {
//        return service.findAll();
//    }
//
//    @Override
//    @GetMapping("/{id}")
//    public Observable<SystemWrapper> findById(@PathVariable(name = "id", required = true) String id) {
//        System.out.println("Executing....");
//        return service.findById(id);
//    }
//
//    @Override
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Observable<SystemWrapper> save(@RequestBody AlcPpb entity) {
//        return service.save(entity);
//    }
//
//    @PostMapping("/all")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Observable<SystemWrapper> save(@RequestBody Iterable<AlcPpb> ts) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    @DeleteMapping("/{id}")
//    public Observable<SystemWrapper> delete(@PathVariable String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Observable<SystemWrapper> delete(AlcPpb entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Observable<SystemWrapper> delete(Iterable<AlcPpb> ts) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
    
}
