package com.company.controller;

import com.company.model.Category;
import com.company.service.category.CategoryServiceIMPL;

import java.util.List;

public class CategoryController {
    private static CategoryController instance;
    public static CategoryController getInstance(){
        if(instance==null){
            instance = new CategoryController();
        }
        return instance;
    }
    public Category findById(int id){
        Category category = CategoryServiceIMPL.getInstance().findById(id);
        return category;
    }
    public void createCategory(String nameCategory){
        int id;
        if(CategoryServiceIMPL.categoryList.size()==0){
            id = 1;
        } else {
            id = CategoryServiceIMPL.categoryList.get(CategoryServiceIMPL.categoryList.size()-1).getId()+1;
        }
        Category category1= new Category(id, nameCategory);
        CategoryServiceIMPL.getInstance().save(category1);
        CategoryServiceIMPL.getInstance().findAll();
    }
    public List<Category> showListCategory(){
        return CategoryServiceIMPL.getInstance().findAll();
    }
}
