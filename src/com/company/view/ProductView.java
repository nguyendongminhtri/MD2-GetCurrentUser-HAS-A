package com.company.view;


import com.company.config.ConfigReadAndWriteFile;
import com.company.controller.CategoryController;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ProductView {
    public void createProduct(){
        System.out.println("=======FORM CREATE PRODUCT======");
        System.out.println("Enter the name Product: ");
        String nameProduct = ConfigReadAndWriteFile.scanner().nextLine();
        System.out.println("Enter the description Product: ");
        String description = ConfigReadAndWriteFile.scanner().nextLine();
        System.out.println("Enter the id of Category: ");
        int id = Integer.parseInt(ConfigReadAndWriteFile.scanner().nextLine());

    }
}
