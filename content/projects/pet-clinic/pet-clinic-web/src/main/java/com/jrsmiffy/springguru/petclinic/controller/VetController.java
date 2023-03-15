package com.jrsmiffy.springguru.petclinic.controller;

import com.jrsmiffy.springguru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequiredArgsConstructor
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    @RequestMapping({"/", ""})
    public String getVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }

}
