package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenereicProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products/";

    private static GenereicProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenereicProductDto genereicProductDto = new GenereicProductDto();
        genereicProductDto.setId(fakeStoreProductDto.getId());
        genereicProductDto.setImage(fakeStoreProductDto.getImage());
        genereicProductDto.setCategory(fakeStoreProductDto.getCategory());
        genereicProductDto.setDescription(fakeStoreProductDto.getDescription());
        genereicProductDto.setTitle(fakeStoreProductDto.getTitle());
        genereicProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genereicProductDto;
    }
    @Override
    public GenereicProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        return convertToGenericProductDto(responseEntity.getBody());
    }



    @Override
    public List<GenereicProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);
        List<GenereicProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }

        return result;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public GenereicProductDto createProduct(GenereicProductDto genereicProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl, genereicProductDto,FakeStoreProductDto.class);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public void updateProductById() {

    }
}
