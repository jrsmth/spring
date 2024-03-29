package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.command.IngredientCommand;
import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.service.IngredientService;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import com.jrsmiffy.springguru.recipes.service.UnitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @RequiredArgsConstructor @Slf4j
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitService unitService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("[listIngredients] Getting ingredient list for recipe id [{}]", recipeId);

        // Note :: Use command object to avoid lazy load errors in Thymeleaf
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String newIngredient(@PathVariable String recipeId, Model model){

        // Make sure we have a good id value
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        // TODO :: raise exception if null

        // Need to return parent id for hidden form property
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);

        // Init unit
        ingredientCommand.setUnit(new UnitCommand());

        model.addAttribute("unitList",  unitService.listAllUnits());

        return "recipe/ingredient/ingredient-form";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("unitList", unitService.listAllUnits());
        return "recipe/ingredient/ingredient-form";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("[saveOrUpdate] Saved recipe with id [{}]", savedCommand.getRecipeId());
        log.debug("[saveOrUpdate] Saved ingredient with id [{}]", savedCommand.getId());

        return String.format("redirect:/recipe/%s/ingredient/%s/show", savedCommand.getRecipeId(), savedCommand.getId());
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String id){
        log.debug("[deleteIngredient] Deleting ingredient with id [{}]", id);
        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(id));

        return String.format("redirect:/recipe/%s/ingredients", recipeId);
    }
}
