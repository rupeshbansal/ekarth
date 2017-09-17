package com.ekarth.controller;

import com.ekarth.model.Category;
import com.ekarth.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class CategoriesController {
    private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public ResponseEntity<List<Category>> addProduct(@RequestParam int custId) {
        List<Category> categoryList = new ArrayList<>();
        try {
            categoryList = categoryService.getAllCategories(custId);
        } catch (Exception e) {
            logger.error("We could not add your details due to ", e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.CREATED);
    }
}
