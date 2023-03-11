package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller @RequiredArgsConstructor @Slf4j
public class IngredientController {

    private final RecipeService recipeService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("[listIngredients] Getting ingredient list for recipe id [{}]", recipeId);

        // Note :: Use command object to avoid lazy load errors in Thymeleaf
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/show";
    }
}
