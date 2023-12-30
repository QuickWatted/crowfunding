package com.example.crowdfunding.categories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    public void createCategory(@RequestBody Categories category) {
        categoriesService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Categories> getCategoryById(@PathVariable Long id) {
        return categoriesService.getCategoryById(id);
    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Categories category) {
        categoriesService.updateCategory(id, category);
    }
}
