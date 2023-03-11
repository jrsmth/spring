package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.command.UnitCommand;
import com.jrsmiffy.springguru.recipes.converter.UnitToUnitCommand;
import com.jrsmiffy.springguru.recipes.model.Unit;
import com.jrsmiffy.springguru.recipes.repository.UnitRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UnitServiceImplTest {
    UnitToUnitCommand unitToUnitCommand = new UnitToUnitCommand();
    UnitService service;

    @Mock UnitRepository unitRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        service = new UnitServiceImpl(unitRepository, unitToUnitCommand);
    }

    @Test
    public void listAllUnits() throws Exception {
        // Given
        Set<Unit> units = new HashSet<>();
        Unit unit1 = new Unit();
        unit1.setId(1L);
        units.add(unit1);

        Unit unit2 = new Unit();
        unit2.setId(2L);
        units.add(unit2);

        when(unitRepository.findAll()).thenReturn(units);

        // When
        Set<UnitCommand> commands = service.listAllUnits();

        // Then
        assertEquals(2, commands.size());
        verify(unitRepository, times(1)).findAll();
    }
}