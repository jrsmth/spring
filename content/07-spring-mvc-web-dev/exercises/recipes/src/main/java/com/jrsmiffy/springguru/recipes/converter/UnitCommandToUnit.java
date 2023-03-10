package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.model.Unit;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitCommandToUnit implements Converter<UnitCommand, Unit> {

    @Synchronized @Nullable @Override
    public Unit convert(UnitCommand source) {
        if (source == null) return null;

        final Unit unit = new Unit();
        unit.setId(source.getId());
        unit.setName(source.getName());
        return unit;
    }
}