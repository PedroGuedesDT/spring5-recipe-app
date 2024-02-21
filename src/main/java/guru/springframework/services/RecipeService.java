package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.io.Serializable;
import java.util.Set;

public interface RecipeService extends Serializable {

    Set<Recipe> findAll();

    Recipe save(Recipe recipe);
}
