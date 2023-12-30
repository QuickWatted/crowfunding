package com.example.crowdfunding.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void createCategory(Categories category) {
        categoriesRepository.save(category);
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        if (id == null) {
            // Handle the case where ID is null, for example, by throwing an exception
            throw new IllegalArgumentException("Category ID must not be null");
        }
        return categoriesRepository.findById(id);
    }


    public void deleteCategory(Long id) {
        categoriesRepository.deleteById(id);
    }

    public void updateCategory(Long id, Categories category) {
        Categories existingCategory = categoriesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Category not found"));
        // Update fields as needed
        existingCategory.setCategoryName(category.getCategoryName());
        // ... update other fields
        categoriesRepository.save(existingCategory);
    }
}