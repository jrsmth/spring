package com.jrsmiffy.springguru.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping("/vets")
    public String listVets(){
        return "vet/index";
    }
    
}
