/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LimaD01
 */
@RestController
public class WelcomeController {
    
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to API dclfactor";
    }
    
}
