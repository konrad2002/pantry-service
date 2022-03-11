package de.logilutions.de.pantryservice.controller;

import de.logilutions.de.pantryservice.model.Category;
import de.logilutions.de.pantryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category/")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return this.categoryService.getCategories();
    }

    @GetMapping("id/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }

    @GetMapping("like/{name}")
    public List<Category> getCategoriesWithNameLike(@PathVariable String name) {
        return categoryService.getCategoriesWithNameLike(name);
    }


    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
