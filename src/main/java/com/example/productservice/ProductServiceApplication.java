package com.example.productservice;

import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     PriceRepository priceRepository,
                                     ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {SpringApplication.run(ProductServiceApplication.class, args);}

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Category category1 = new Category();
//        category1.setName("Apple Product");
//        Category category2 = new Category();
//        category2.setName("Samsung Product");
//        List<Category> savedCategory = categoryRepository.saveAll(List.of(
//                category1,category2
//        ));
//
//        List<Price> savedPrices = priceRepository.saveAll(List.of(
//                new Price("INR", 50000),
//                new Price("INR", 100000),
//                new Price("INR", 150000)
//        ));
//
//        Product product1 = new Product();
//        product1.setCategory(savedCategory.get(0));
//        product1.setTitle("Iphone 15 pro");
//        product1.setImage("img15");
//        product1.setDescription("Best Iphone ever");
//        product1.setPrice(savedPrices.get(0));
//
//        Product product2 = new Product();
//        product2.setCategory(savedCategory.get(0));
//        product2.setTitle("Iphone 14 pro");
//        product2.setImage("img14");
//        product2.setDescription("Best Iphone ever");
//        product2.setPrice(savedPrices.get(1));
//
//        Product product3 = new Product();
//        product3.setCategory(savedCategory.get(1));
//        product3.setTitle("Samsung Foldable");
//        product3.setImage("img_sam");
//        product3.setDescription("Samsung foldable");
//        product3.setPrice(savedPrices.get(2));
//
//        List<Product> savedProducts = productRepository.saveAll(List.of(
//                product1, product2, product3
//        ));

        List<Product> products = productRepository.findAll();
        for(Product product: products){
            System.out.println("| " + product.getTitle() + " | " + product.getPrice().getValue());

        }

    }
}
