package com.company.service.category;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Category;
import com.company.model.User;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    public static String PATH_CATEGORY = ConfigReadAndWriteFile.PATH + "category.txt";
    public static List<Category> categoryList = new ConfigReadAndWriteFile<Category>().readFromFile(PATH_CATEGORY);
    private static CategoryServiceIMPL instance;
    public static CategoryServiceIMPL getInstance(){
        if(instance==null){
            instance = new CategoryServiceIMPL();
        }
        return instance;
    }
    @Override
    public List findAll() {
        new ConfigReadAndWriteFile<Category>().writeToFile(PATH_CATEGORY, categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        User user = UserPrincipalServiceIMPL.getInstance().getCurrentUser();
        category.setUser(user);
        categoryList.add(category);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Category> findByUser() {
        List<Category> listCategoryByUser = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            if(categoryList.get(i).getUser().getUsername().equals(UserPrincipalServiceIMPL.getInstance().getCurrentUser().getUsername())){
                listCategoryByUser.add(categoryList.get(i));
            }
        }
        return listCategoryByUser;
    }
}
