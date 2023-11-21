package com.example.productservice.controllers;

import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id ){
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts(){

    }

    @DeleteMapping("/id")
    public void deleteProductById(){

    }


    public void createProduct(){

    }

    public void updateProductById(){

    }
}
