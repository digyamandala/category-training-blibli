package com.company.categoryapp.service;

import com.company.categoryapp.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    private ArrayList<Category> categories = new ArrayList<>();
    @Override
    public Category create(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        Category curr;
        for(int i = 0 ; i < categories.size() ; i++){
            curr = categories.get(i);
            if(category.getCategoryid().equals(curr.getCategoryid())){
                categories.set(i, category);
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public Category delete(String id) {
        Category curr;
        for(int i = 0 ; i < categories.size() ; i++){
            curr = categories.get(i);

            if(id.equals(curr.getCategoryid())){
                categories.remove(curr);
                return curr;
            }
        }
        return null;
    }

    @Override
    public Category findById(String id) {

        for(int i = 0 ; i < categories.size() ; i++){
            if(id.equals(categories.get(i).getCategoryid())){
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }
}
