package com.scaler.productservicejan31capstone.dtos;

import com.scaler.productservicejan31capstone.models.Category;
import com.scaler.productservicejan31capstone.models.Product;

public class FakestoreProductDto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.title);
        //product.setCategory(this.category);
        product.setDescription(this.description);
        product.setPrice(this.price);

        Category category1 = new Category();
        //category1.setId(this.id);
        category1.setName(this.category);
        product.setCategory(category1);

        return product;
    }
}
