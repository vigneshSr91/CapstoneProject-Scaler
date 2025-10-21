package com.scaler.productservicejan31capstone.controllers;

import com.scaler.productservicejan31capstone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
@SpringBootTest
class ProductControllerTest {
    @MockitoBean
    public ProductService productService;
    @Autowired
    public ProductController productController;

    public void testGetProductByIdReturnsProduct(){

    }
}