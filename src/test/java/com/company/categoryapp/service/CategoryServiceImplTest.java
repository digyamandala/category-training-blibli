package com.company.categoryapp.service;

import com.company.categoryapp.entity.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryServiceImplTest {
    private CategoryServiceImpl service;

    @Before
    public void setUp() throws Exception{
        service = new CategoryServiceImpl();
    }

    @Test
    public void testCreate(){

        Category category = new Category("2", "Electronic");
        service.create(category);

        category = new Category("1", "Fashion");
        service.create(category);

        Assert.assertTrue("Data must be two", service.findAll().size() == 2);

        Category temp = service.findById("1");
        Assert.assertTrue("Id must be 1", temp == category);

    }

    @Test
    public void testFindById(){

        Category category = service.findById("popo");
        Assert.assertTrue("Data should be kosong", category == null);

        service.create(new Category("2", "Movies"));

        category = service.findById("2");
        Assert.assertTrue("Data should be found", category != null);
    }

    @Test
    public void testUpdate() {
        Category cg = new Category("3", "Laptop");
        service.create(cg);

        Category up = new Category("3", "Electronic");
        cg = service.update(up);

        Assert.assertTrue("Name must be Hape", cg.getCategoryName().equals("Electronic"));

        cg = service.update(new Category("23", "ppopopo"));
        Assert.assertTrue("Should be none", cg == null);
    }

    @Test
    public void testDelete(){

        service.create(new Category("1", "Fashion"));
        service.create(new Category("2", "Music"));
        service.create(new Category("3", "Game"));
        service.create(new Category("4", "Payment"));

        Category del = service.delete("4");
        Assert.assertTrue("len shoudl be three", service.findAll().size() == 3);

        Category delnul = service.delete("10");
        Assert.assertTrue("should be not found", delnul == null);

    }


}
