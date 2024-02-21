package guru.springframework.services;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public Category find(String description) {
        return categoryRepository.findByDescription(description).orElse(null);
    }
}
