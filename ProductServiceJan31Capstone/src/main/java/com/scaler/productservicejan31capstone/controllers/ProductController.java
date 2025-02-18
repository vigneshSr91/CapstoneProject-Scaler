package com.scaler.productservicejan31capstone.controllers;

import com.scaler.productservicejan31capstone.dtos.ProductResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping(value="/product/{id}")
    public ProductResponseDto getProductById(@PathVariable long id){
        ProductResponseDto dummyProductResponseDto = new ProductResponseDto();
        dummyProductResponseDto.setId(1);
        dummyProductResponseDto.setName("Product" + id);
        dummyProductResponseDto.setDescription("dummy Product");
        dummyProductResponseDto.setPrice(11.23);
        dummyProductResponseDto.setImageUrl("https://dummy.image.net");
        return dummyProductResponseDto;
    }
}
