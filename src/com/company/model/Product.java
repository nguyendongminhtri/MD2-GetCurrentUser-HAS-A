package com.company.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String nameProduct;
    private String description;
    private String price;
    private User user;
    private Category category;
    public Product() {
    }

    public Product(int id, String nameProduct, String description, String price, User user, Category category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.user = user;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
