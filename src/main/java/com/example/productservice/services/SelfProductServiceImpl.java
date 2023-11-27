package com.example.productservice.services;

import com.example.productservice.dtos.GenereicProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenereicProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenereicProductDto> getAllProducts() {

        return null;
    }

    @Override
    public GenereicProductDto deleteProductById(Long id) {

        return null;
    }

    @Override
    public GenereicProductDto createProduct(GenereicProductDto genereicProductDto) {
        return null;
    }

    @Override
    public void updateProductById() {

    }
}
