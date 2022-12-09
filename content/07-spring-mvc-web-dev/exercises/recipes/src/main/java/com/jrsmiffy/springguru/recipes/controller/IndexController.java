package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequiredArgsConstructor @Slf4j
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.info("Serving the index page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
