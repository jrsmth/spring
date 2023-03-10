package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.CategoryCommand;
import com.jrsmiffy.springguru.recipes.model.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized @Nullable @Override
    public CategoryCommand convert(Category source) {
        if (source == null) return null;

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setName(source.getName());

        return categoryCommand;
    }
}