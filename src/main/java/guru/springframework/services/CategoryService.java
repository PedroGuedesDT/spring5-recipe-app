package guru.springframework.services;

import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;

import java.io.Serializable;
import java.util.Set;

public interface CategoryService extends Serializable {

    Category find(String description);
}
