package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void findAll() {

        HashSet<Recipe> recipesSet = new HashSet<>();
        recipesSet.add(new Recipe());

        Mockito.when(recipeService.findAll()).thenReturn(recipesSet);

        Set<Recipe> recipes = this.recipeService.findAll();
        assertEquals(1, recipes.size());
        verify(recipeRepository, Mockito.times(1)).findAll();
    }
}