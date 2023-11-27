package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenereicProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.thirdPartyClients.fakestoreclient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreClientAdapter fakeStoreClientAdapter;

    public FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }

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
    public GenereicProductDto getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(fakeStoreClientAdapter.getProductById(id));
    }

    @Override
    public List<GenereicProductDto> getAllProducts() {
        List<GenereicProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProducts();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }

        return result;
    }

    @Override
    public GenereicProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreClientAdapter.deleteProductById(id));
    }

    @Override
    public GenereicProductDto createProduct(GenereicProductDto genereicProductDto) {
        return convertToGenericProductDto(fakeStoreClientAdapter.createProduct(genereicProductDto));
    }

    @Override
    public void updateProductById() {

    }
}
