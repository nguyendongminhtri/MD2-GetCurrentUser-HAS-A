package com.company.service.product;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;
import com.company.model.User;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.List;


public class ProductServiceIMPL implements IProductService {
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    public static String PATH_PRODUCT = ConfigReadAndWriteFile.PATH + "product.txt";
    public static List<Product> productList = new ConfigReadAndWriteFile<Product>().readFromFile(PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        new ConfigReadAndWriteFile<Product>().writeToFile(PATH_PRODUCT, productList);
        return productList;
    }
    @Override
    public void save(Product product) {
        User user = userPrincipalServiceIMPL.getCurrentUser();
        product.setUser(user);
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
