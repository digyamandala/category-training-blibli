package com.company.categoryapp.controller;

import com.company.categoryapp.entity.ApiKey;
import com.company.categoryapp.entity.Category;
import com.company.categoryapp.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public CategoryController(CategoryService categoryService,
                              KafkaTemplate<String, String> kafkaTemplate,
                              ObjectMapper objectMapper) {
        this.categoryService = categoryService;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category create(@RequestBody Category cg, ApiKey apiKey){
        return categoryService.create(cg);
    }

    @RequestMapping(
            value = "/categories/name/{categoryName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category findByCategoryName(@PathVariable("categoryName") String categoryName, ApiKey apiKey){
        return categoryService.findByCategoryName(categoryName);
    }

    @RequestMapping(
            value = "/categories/id/{idCategories}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category findById(@PathVariable("idCategories") String id, ApiKey apiKey){

        return categoryService.findById(id);
    }


    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Category> findAll(ApiKey apiKey) {
        return categoryService.findAll();
    }

    @RequestMapping(
            value = "/categories/{idCategories}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category delete(@PathVariable("idCategories") String id, ApiKey apiKey){
        return categoryService.delete(id);
    }

    @RequestMapping(
            value = "/categories/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Category update(@RequestBody Category cg, ApiKey apiKey){
        return categoryService.update(cg);
    }

    @RequestMapping(
            value = "/publish/categories",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String publish() throws JsonProcessingException {
        List<Category> categoryList = categoryService.findAll();

        String json = objectMapper.writeValueAsString(categoryList);



        kafkaTemplate.send("categories", json);
        return "Data Categories has been sent";
    }
}
