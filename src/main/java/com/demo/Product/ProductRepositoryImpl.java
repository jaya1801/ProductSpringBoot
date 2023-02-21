package com.demo.Product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    Map<Integer,ProductDto> productDtoMap = new HashMap<>();

    @Override
    public ProductDto addProduct(ProductDto product) {
        productDtoMap.put(product.getId(),product);
        return product;
    }

    @Override
    public ProductDto getProduct(Integer id) {
        return productDtoMap.get(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productDtoMap.replace(productDto.getId(),productDto);
    }

    @Override
    public ProductDto deleteProduct(Integer productId) {
        return productDtoMap.remove(productId);
    }



}
