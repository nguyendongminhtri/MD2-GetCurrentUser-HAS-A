package com.company.view;

import com.company.config.ConfigReadAndWriteFile;
import com.company.controller.CategoryController;
import com.company.model.Category;
import com.company.service.category.CategoryServiceIMPL;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class CategoryView {
    private static CategoryView instance;
    public  static CategoryView getInstance(){
        if(instance==null){
            instance = new CategoryView();
        }
        return instance;
    }
    public CategoryView(){
        System.out.println("1. CREATE CATEGORY");
        System.out.println("2. SHOW LIST CATEGORY");
        System.out.println("3. LIST CATEGORY BY USER");
        int choose = ConfigReadAndWriteFile.scanner().nextInt();
        switch (choose){
            case 1:
                createCategory();
                break;
            case 2:
                showListCategory();
                break;
            case 3:
                listCategoryByUser();
                break;
        }
    }
    public void createCategory(){
        while (true){
            System.out.println("==================CREATE CATEGORY ===================");
            System.out.println("Enter the name Category: ");
            String nameCategory = ConfigReadAndWriteFile.scanner().nextLine();
            CategoryController.getInstance().createCategory(nameCategory);
            System.out.println("Enter any key to continue create category or enter quit to come back Menu");
            String backMenu = ConfigReadAndWriteFile.scanner().nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }
    public void showListCategory(){
        System.out.println(CategoryController.getInstance().showListCategory());
        System.out.println("Enter any key to continue create category or enter quit to come back Menu");
        String backMenu = ConfigReadAndWriteFile.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public  void listCategoryByUser(){
        for (int i = 0; i < CategoryServiceIMPL.getInstance().findByUser().size(); i++) {
            System.out.println(CategoryServiceIMPL.getInstance().findByUser().get(i));
        }
        System.out.println("Enter any key to continue create category or enter quit to come back Menu");
        String backMenu = ConfigReadAndWriteFile.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
}
