package com.jrsmiffy.springguru.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"}) // note: is all of this nec?
    public String index(){
        return "index";
    }

}
