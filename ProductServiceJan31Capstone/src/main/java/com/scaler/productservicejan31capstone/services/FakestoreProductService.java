package com.scaler.productservicejan31capstone.services;

import com.scaler.productservicejan31capstone.dtos.FakestoreProductDto;
import com.scaler.productservicejan31capstone.dtos.FakestoreProductRequestDto;
import com.scaler.productservicejan31capstone.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Product> getAllProducts() {
        FakestoreProductDto[] fakestoreProductDtos = restTemplate.getForObject(
                                                                "https://fakestoreapi.com/products",
                                                                    FakestoreProductDto[].class );
        List<Product> products = new ArrayList<>();

        for ( FakestoreProductDto fakestoreProductDto  : fakestoreProductDtos){
            Product product = fakestoreProductDto.toProduct();
            products.add(product);
        }

        return products;
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        FakestoreProductRequestDto fakestoreProductRequestDto =
                new FakestoreProductRequestDto();
        fakestoreProductRequestDto.setTitle(name);
        fakestoreProductRequestDto.setDescription(description);
        fakestoreProductRequestDto.setPrice(price);
        fakestoreProductRequestDto.setCategory(category);
        fakestoreProductRequestDto.setImage(imageUrl);
        FakestoreProductDto fakestoreProductDto =
                restTemplate.postForObject("https://fakestoreapi.com/products",
                                                fakestoreProductRequestDto,
                                                FakestoreProductDto.class);

        return fakestoreProductDto.toProduct();
    }
}
