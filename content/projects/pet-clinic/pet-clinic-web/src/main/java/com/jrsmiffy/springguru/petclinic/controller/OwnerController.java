package com.jrsmiffy.springguru.petclinic.controller;

import com.jrsmiffy.springguru.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"/", ""})
    public String getOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

}
