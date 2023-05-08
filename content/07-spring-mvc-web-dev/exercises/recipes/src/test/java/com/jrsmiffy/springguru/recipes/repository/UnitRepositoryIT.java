package com.jrsmiffy.springguru.recipes.repository;

import com.jrsmiffy.springguru.recipes.model.Unit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest @ActiveProfiles("local")
public class UnitRepositoryIT {

    @Autowired
    UnitRepository unitRepository;

    @Test
    public void findByName() {
        // Given
        Unit unit = null;

        // When
        Optional<Unit> result = unitRepository.findByName("Teaspoon");

        // Then
        if (result.isPresent()) unit = result.get();

        assert unit != null;
        assertEquals("Teaspoon", unit.getName());
    }


}