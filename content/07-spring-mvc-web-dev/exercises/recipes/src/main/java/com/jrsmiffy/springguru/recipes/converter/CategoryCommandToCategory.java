package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.CategoryCommand;
import com.jrsmiffy.springguru.recipes.model.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    // Note: I wonder if there is a way to generalise the command to model conversion <S, T>

    @Synchronized @Nullable @Override
    public Category convert(CategoryCommand source) {
        if (source == null) return null;

        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());
        return category;
    }

}
