package com.jrsmiffy.springguru.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

/**
    @RequestMapping({"", "/",})
    public String index(){
        return "index";
    }
    note: is this actually unnecessary, as Spring will serve /index.html for "/" and "" (empty) by default
 */

    @RequestMapping("/oops")
    public String oopsHandler(){
        return "unimplemented";
    }

}
