package com.scaler.productservicejan31capstone.services;

import com.scaler.productservicejan31capstone.exceptions.ProductNotFoundException;
import com.scaler.productservicejan31capstone.models.Category;
import com.scaler.productservicejan31capstone.models.Product;
import com.scaler.productservicejan31capstone.repositories.CategoryRepository;
import com.scaler.productservicejan31capstone.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productDBService")
public class ProductDBService implements ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with Id " + id + " not found");
        } else {
            return optionalProduct.get();
        }
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryObj = getCategoryFromDB(category);
        categoryObj.setName(category);

        product.setCategory(categoryObj);
        return productRepository.save(product);


    }

    private Category getCategoryFromDB(String name){
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if(optionalCategory.isPresent()){
            return  optionalCategory.get();
        }
        Category category = new Category();
        category.setName(name);

        return categoryRepository.save(category);
    }
}
