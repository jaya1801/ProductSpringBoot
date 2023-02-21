package com.demo.Product;

public interface ProductRepository {

    ProductDto addProduct(ProductDto product);
    ProductDto getProduct(Integer id);
    ProductDto updateProduct(ProductDto productDto);
    ProductDto deleteProduct(Integer productId);
}
