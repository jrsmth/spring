package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.UnitCommand;

import java.util.Set;

public interface UnitService {

    Set<UnitCommand> listAllUnits();
}
