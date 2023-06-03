package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataMongoTest @RunWith(SpringRunner.class)
public class RecipeReactiveRepositoryTest {

    @Autowired
    RecipeReactiveRepository subject;

    @Before
    public void setUp() throws Exception {
        subject.deleteAll().block();
    }

    @Test
    public void testRecipeSave() {
        // given:
        Recipe recipe = new Recipe();
        recipe.setDescription("Tasty scran");

        // when:
        subject.save(recipe).block();
        // subject.save(recipe); // Note :: .save() behaves 'reactively', without return unless we .block() the process

        // then:
        assertEquals(Long.valueOf(1L), subject.count().block());

    }

}