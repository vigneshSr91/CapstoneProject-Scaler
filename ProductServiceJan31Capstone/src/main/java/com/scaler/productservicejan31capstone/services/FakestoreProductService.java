package com.scaler.productservicejan31capstone.services;

import com.scaler.productservicejan31capstone.dtos.FakestoreProductDto;
import com.scaler.productservicejan31capstone.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakestoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakestoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        FakestoreProductDto fakestoreProductDto =
                                restTemplate.getForObject(
                                    "https://fakestoreapi.com/products/" + id,
                                        FakestoreProductDto.class);
        return fakestoreProductDto.toProduct();
    }
}
