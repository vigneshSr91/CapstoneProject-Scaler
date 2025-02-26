package com.scaler.productservicejan31capstone.controllers;

import com.scaler.productservicejan31capstone.dtos.ProductResponseDto;
import com.scaler.productservicejan31capstone.models.Product;
import com.scaler.productservicejan31capstone.services.FakestoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    FakestoreProductService fakestoreProductService;

    public ProductController(FakestoreProductService fakestoreProductService){
        this.fakestoreProductService = fakestoreProductService;
    }

    @GetMapping(value="/product/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id){
        Product product = fakestoreProductService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> productResponseDtoResponseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.OK);

        return productResponseDtoResponseEntity;
    }
}
