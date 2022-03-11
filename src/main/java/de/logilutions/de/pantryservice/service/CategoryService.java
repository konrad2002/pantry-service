package de.logilutions.de.pantryservice.service;

import de.logilutions.de.pantryservice.model.Category;
import de.logilutions.de.pantryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        if (category == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with given id " + id + " does not exist");
        return category;
    }

    public Category getCategoryByName(String name) {
        Category category = categoryRepository.findCategoryByName(name);
        if (category == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with given name '" + name + "' does not exist");
        return category;
    }

    public List<Category> getCategoriesWithNameLike(String name) {
        return categoryRepository.findAllByNameLike(name);
    }



    public Category addCategory(Category category) {
        if (category.getId() != null) {
            category.setId(null);
        }
        return saveCategory(category);
    }

    public Category saveCategory(Category category) {
        if (category.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty category name is not allowed");
        }

        if (categoryRepository.findCategoryByName(category.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category with given name '" + category.getName() + "' already exists");
        }

        return this.categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        if (category == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with given id " + id + " does not exist");
        else categoryRepository.delete(category);
    }
}
