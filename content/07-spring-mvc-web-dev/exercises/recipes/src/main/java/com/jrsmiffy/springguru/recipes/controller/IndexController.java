package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @Slf4j // @RequiredArgsConstructor
// NOTE: I implemented a constructor instead bc JUnit was giving me jip:
        // NOTE: Java 'constructor in class cannot be applied to given types' 'required: no arguments found...'
            // NOTE: IntelliJ JUnit Lombok issues can be resolved by re-syncing the project and doing `mvn clean install`
                // NOTE: Also ensure the annotation processors are enabled (Preferences > Build, Execution... > Compiler)
public class IndexController {

    private final RecipeService recipeService;

    public IndexController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.info("Serving the index page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
