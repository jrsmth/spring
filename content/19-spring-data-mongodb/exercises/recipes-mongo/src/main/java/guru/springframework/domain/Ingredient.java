package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

/**
 * Created by jt on 6/13/17.
 */
@Getter
@Setter
public class Ingredient {

    @Id private String id;
    private String description;
    private BigDecimal amount;

    @DBRef private UnitOfMeasure uom;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        // this.recipe = recipe;
    }

}