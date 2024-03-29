package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.exception.NotFoundException;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller @Slf4j
public class RecipeController {

    private final RecipeService recipeService;
    private static final String RECIPE_FORM_URL = "recipe/recipe-form";

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        // Note :: we use the Command objects to interact with the frontend to avoid directly exposing our model

        return RECIPE_FORM_URL;
    }

    @PostMapping("recipe") @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
    // @ResponseStatus(HttpStatus.CREATED) // Note :: This was preventing the redirect (302 instead)
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> log.debug(objectError.toString()));

            return RECIPE_FORM_URL;
        }

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return String.format("redirect:/recipe/%s/show", savedCommand.getId());
    }

    @RequestMapping("recipe/{id}/update") // Question :: could be @PutMapping?
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return RECIPE_FORM_URL;
    }

    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ExceptionHandler(NotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Handling NotFoundException!");

        return new ModelAndView("error/not-found", Map.of("exception", exception));
    }

    // Note :: This has been moved into ControllerExceptionHandler, as part of the @ControllerAdvice refactor
//    @ExceptionHandler(NumberFormatException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ModelAndView handleNumberFormatException(Exception exception) {
//        log.error("Handling NumberFormatException!");
//
//        return new ModelAndView("error/bad-request", Map.of("exception", exception));
//    }

}
