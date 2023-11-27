package com.example.productservice.controllers;

import com.example.productservice.dtos.GenereicProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenereicProductDto getProductById(@PathVariable("id") Long id ) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenereicProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenereicProductDto deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenereicProductDto createProduct(@RequestBody GenereicProductDto genereicProductDto){
        return productService.createProduct(genereicProductDto);
    }

    public void updateProductById(){

    }
}
