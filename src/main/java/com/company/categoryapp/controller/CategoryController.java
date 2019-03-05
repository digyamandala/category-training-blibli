package com.company.categoryapp.controller;

import com.company.categoryapp.Category;
import com.company.categoryapp.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category create(@RequestBody Category cg){

        return categoryService.create(cg);
    }

    @RequestMapping(
            value = "/categories/{idCategories}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category findById(@PathVariable("idCategories") String id){

        return categoryService.findById(id);
    }


    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(
            value = "/categories/{idCategories}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category delete(@PathVariable("idCategories") String id){
        return categoryService.delete(id);
    }

    @RequestMapping(
            value = "/categories/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category update(@RequestBody Category cg){
        return categoryService.update(cg);
    }
}
