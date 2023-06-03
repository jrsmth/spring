package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataMongoTest @RunWith(SpringRunner.class)
public class CategoryReactiveRepositoryTest {

    @Autowired
    CategoryReactiveRepository subject;

    private final String DESC = "Tasty scran";

    @Before
    public void setUp() throws Exception {
        subject.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        // given:
        Category category = new Category();
        category.setDescription(DESC);

        // when:
        subject.save(category).block();

        // then:
        assertEquals(Long.valueOf(1L), subject.count().block());

    }

    @Test
    public void testFindByDescription() throws Exception {
        // given:
        Category category = new Category();
        category.setDescription(DESC);

        // when:
        subject.save(category).then().block();

        // then:
        String fetchedId = Objects.requireNonNull(subject.findByDescription(DESC).block()).getId();
        assertNotNull(fetchedId);

    }

}