package com.jrsmiffy.springguru.recipes.command;

import com.jrsmiffy.springguru.recipes.model.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class RecipeCommand {
    private Long id;

    @NotBlank @Size(min = 3, max = 255) private String description;

    @Min(1) @Max(999) private Integer prepMins;
    @Min(1) @Max(999) private Integer cookMins;
    @Min(1) @Max(100) private Integer servings;

    private String source;

    @URL private String url;

    @NotBlank private String directions;

    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();

}