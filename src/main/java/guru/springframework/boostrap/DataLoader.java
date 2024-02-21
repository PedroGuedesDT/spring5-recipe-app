package guru.springframework.boostrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.services.CategoryService;
import guru.springframework.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public void loadRecipes() {

        Category mexicanCategory = categoryService.find("Mexican");
        Category veganCategory = categoryService.find("Vegan");

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setServings(2);
        guacamoleRecipe.getCategories().add(mexicanCategory);
        guacamoleRecipe.getCategories().add(veganCategory);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setCookTime(10);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/#structured-project-content_1-0");

        recipeService.save(guacamoleRecipe);


        Category spicyCategory = categoryService.find("Spicy");
        Category chickenCategory = categoryService.find("Chicken");

        Recipe chickenRecipe = new Recipe();
        chickenRecipe.setDescription("Spicy Grilled Chicken Tacos");
        chickenRecipe.setServings(4);
        chickenRecipe.getCategories().add(mexicanCategory);
        chickenRecipe.getCategories().add(spicyCategory);
        chickenRecipe.getCategories().add(chickenCategory);
        chickenRecipe.setDifficulty(Difficulty.MODERATE);
        chickenRecipe.setCookTime(20);
        chickenRecipe.setPrepTime(15);
        chickenRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#structured-project-content_1-0");

        recipeService.save(chickenRecipe);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        loadRecipes();
    }
}
