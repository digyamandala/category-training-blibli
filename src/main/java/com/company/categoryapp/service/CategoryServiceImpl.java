package com.company.categoryapp.service;

import com.company.categoryapp.entity.Category;
import com.company.categoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

//    private ArrayList<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {

        //USING REPOSITORY
        return categoryRepository.save(category);

    }

    @Override
    public Category update(Category category) {

        //USING REPOSITORY
        Optional<Category> optional = categoryRepository.findById(category.getId());
        if(optional.isPresent()){
            Category temp;
            temp = optional.get();
            temp.setCategoryName(category.getCategoryName());

            return categoryRepository.save(temp);
        }
        return null;
    }

    @Override
    public Category delete(String id) {

        //USING REPOSITORY
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent()) {
            Category temp = optional.get();
            categoryRepository.delete(temp);
            return temp;
        }
        return null;
    }

    @Override
    public Category findById(String id) {

        //USING REPOSITORY
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent()){
            Category temp = optional.get();
            return temp;
        }
        return null;
    }

    @Override
    public Category findByCategoryName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
