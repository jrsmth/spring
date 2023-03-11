package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.converter.UnitToUnitCommand;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitToUnitCommand unitToUnitCommand;

    @Override
    public Set<UnitCommand> listAllUnits() {

        return StreamSupport.stream(unitRepository.findAll()
                        .spliterator(), false)
                .map(unitToUnitCommand::convert)
                .collect(Collectors.toSet());
    }
}
