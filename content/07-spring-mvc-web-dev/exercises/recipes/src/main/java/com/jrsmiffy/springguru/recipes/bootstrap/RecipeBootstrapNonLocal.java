package com.jrsmiffy.springguru.recipes.bootstrap;

import com.jrsmiffy.springguru.recipes.model.Category;
import com.jrsmiffy.springguru.recipes.model.Unit;
import com.jrsmiffy.springguru.recipes.repository.CategoryRepository;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component @Profile({"dev", "prod"})
@Slf4j @RequiredArgsConstructor
public class RecipeBootstrapNonLocal implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitRepository unitRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitRepository.count() == 0L){
            log.debug("Loading Units");
            loadUnit();
        }
        
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setName("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setName("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setName("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setName("Fast Food");
        categoryRepository.save(cat4);

    }

    private void loadUnit(){
        Unit unit1 = new Unit();
        unit1.setName("Teaspoon");
        unitRepository.save(unit1);

        Unit unit2 = new Unit();
        unit2.setName("Tablespoon");
        unitRepository.save(unit2);

        Unit unit3 = new Unit();
        unit3.setName("Cup");
        unitRepository.save(unit3);

        Unit unit4 = new Unit();
        unit4.setName("Pinch");
        unitRepository.save(unit4);

        Unit unit5 = new Unit();
        unit5.setName("Ounce");
        unitRepository.save(unit5);

        Unit unit6 = new Unit();
        unit6.setName("Each");
        unitRepository.save(unit6);

        Unit unit7 = new Unit();
        unit7.setName("Pint");
        unitRepository.save(unit7);

        Unit unit8 = new Unit();
        unit8.setName("Dash");
        unitRepository.save(unit8);

    }

}