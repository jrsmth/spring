package com.jrsmiffy.springguru.petclinic.controller;

import com.jrsmiffy.springguru.petclinic.model.Vet;
import com.jrsmiffy.springguru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller @RequiredArgsConstructor
//@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    //@RequestMapping({"/", ""})
    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    // Note :: I suppose this should be plural "vet(s)", as we are dealing with all vets, rather than an individual
    public String getVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }

}
