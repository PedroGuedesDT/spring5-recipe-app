package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements  RecipeService {

    private final RecipeRepository recipeController;

    @Override
    public Set<Recipe> findAll() {
        Iterable<Recipe> allRecipes = recipeController.findAll();
        return new HashSet<>((Collection<Recipe>) allRecipes);
    }

    @Override
    public Recipe save(Recipe recipe) {
        if (recipe != null) {
            recipe = recipeController.save(recipe);
        }
        return recipe;
    }
}
