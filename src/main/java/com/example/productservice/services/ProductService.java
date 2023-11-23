package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenereicProductDto;

import java.util.List;

public interface ProductService {
    GenereicProductDto getProductById(Long id );
    List<GenereicProductDto> getAllProducts();
    void deleteProductById();
    GenereicProductDto createProduct(GenereicProductDto genereicProductDto);
    void updateProductById();
}
