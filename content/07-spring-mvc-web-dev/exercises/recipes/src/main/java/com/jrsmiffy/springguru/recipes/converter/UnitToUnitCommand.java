package com.jrsmiffy.springguru.recipes.converter;

import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.model.Unit;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitToUnitCommand implements Converter<Unit, UnitCommand> {

    @Synchronized @Nullable @Override
    public UnitCommand convert(Unit unit) {
        if (unit != null) {
            final UnitCommand unitCommand = new UnitCommand();
            unitCommand.setId(unit.getId());
            unitCommand.setName(unit.getName());
            return unitCommand;
        }

        return null;
    }
}
