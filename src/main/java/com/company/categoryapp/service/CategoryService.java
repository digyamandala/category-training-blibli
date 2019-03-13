package com.company.categoryapp.service;

import com.company.categoryapp.entity.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category update(Category category);
    Category delete(String id);
    Category findById(String id);
    Category findByCategoryName(String name);
    List<Category> findAll();
}
