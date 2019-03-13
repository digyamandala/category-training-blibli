package com.company.categoryapp.service;

import com.company.categoryapp.entity.Category;
import com.company.categoryapp.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {


    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void testSave(){
        categoryRepository.save(new Category("1000", "Popo"));
        Assert.assertTrue(categoryRepository.findById("1000").isPresent());
        Assert.assertTrue(categoryRepository.findByCategoryName("Popo") != null);

        Assert.assertTrue(!categoryRepository.findById("909090").isPresent());
    }

    @Test
    public void testDelete(){
        categoryRepository.deleteById("1000");
        Assert.assertTrue(categoryRepository.findByCategoryName("Popo") == null);
        Assert.assertTrue(!categoryRepository.findById("1000").isPresent());
    }

}
