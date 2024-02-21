package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor
public class HomeController {

    private final RecipeService recipeService;
    @GetMapping({"", "/", "/index", "/index.html", "/home", "/home.html"})
    public String homePage(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }
}
