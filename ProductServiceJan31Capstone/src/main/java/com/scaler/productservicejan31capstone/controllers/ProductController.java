package com.scaler.productservicejan31capstone.controllers;

import com.scaler.productservicejan31capstone.dtos.CreateFakestoreProductDto;
import com.scaler.productservicejan31capstone.dtos.ProductResponseDto;
import com.scaler.productservicejan31capstone.models.Product;
import com.scaler.productservicejan31capstone.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value="/product/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> productResponseDtoResponseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.OK);

        return productResponseDtoResponseEntity;
    }

    @GetMapping(value = "/products")
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();

        List<ProductResponseDto> productResponseDtos = new ArrayList<>( );

        for (Product product : products){
            productResponseDtos.add(ProductResponseDto.from(product));
        }

        return productResponseDtos;
    }
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody
                                            CreateFakestoreProductDto createFakestoreProductDto){
        Product product =
            productService.createProduct(
                    createFakestoreProductDto.getName(),
                    createFakestoreProductDto.getDescription(),
                    createFakestoreProductDto.getPrice(),
                    createFakestoreProductDto.getImageUrl(),
                    createFakestoreProductDto.getCategory()
            );

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);
        return productResponseDto;
    }
}
