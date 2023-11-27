package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenereicProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    GenereicProductDto getProductById(Long id ) throws ProductNotFoundException;
    List<GenereicProductDto> getAllProducts();
    GenereicProductDto deleteProductById(Long id);
    GenereicProductDto createProduct(GenereicProductDto genereicProductDto);
    void updateProductById();
}
