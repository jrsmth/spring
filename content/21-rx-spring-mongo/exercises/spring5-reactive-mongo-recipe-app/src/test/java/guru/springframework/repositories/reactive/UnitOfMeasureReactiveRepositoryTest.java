package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataMongoTest @RunWith(SpringRunner.class)
public class UnitOfMeasureReactiveRepositoryTest {

    @Autowired
    UnitOfMeasureReactiveRepository subject;

    public static final String EACH = "Each";

    @Before
    public void setUp() throws Exception {
        subject.deleteAll().block();
    }

    @Test
    public void testSaveUnit() throws Exception {
        // given:
        UnitOfMeasure unit = new UnitOfMeasure();
        unit.setDescription(EACH);

        // when:
        subject.save(unit).block();

        // then:
        assertEquals(Long.valueOf(1L), subject.count().block());

    }

    @Test
    public void testFindByDescription() throws Exception {
        // given:
        UnitOfMeasure unit = new UnitOfMeasure();
        unit.setDescription(EACH);

        // when:
        subject.save(unit).block();

        // then:
        UnitOfMeasure fetchedUnit = subject.findByDescription(EACH).block();
        assertEquals(EACH, fetchedUnit.getDescription());

    }

}