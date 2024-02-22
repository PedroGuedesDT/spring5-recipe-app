package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

public class HomeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    HomeController homeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.homeController = new HomeController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void homePage() {
        final String expectedResult = "index";
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe().setId(1L));
        recipes.add(new Recipe().setId(2L));

        Mockito.when(recipeService.findAll()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> recipeSetArgCaptur = ArgumentCaptor.forClass(Set.class);

        String result = this.homeController.homePage(model);
        Mockito.verify(model, Mockito.times(1)).addAttribute(eq("recipes"), recipeSetArgCaptur.capture());
        Mockito.verify(recipeService, Mockito.times(1)).findAll();
        assertEquals(expectedResult, result);
        assertEquals(2, recipeSetArgCaptur.getValue().size());

    }
}