package com.demo.Product;

public interface ProductService {

    ProductDto registerProduct(ProductDto newProduct);
    ProductDto getProductById(Integer productId)throws ProductException;
    ProductDto updateProduct(ProductDto product);
    ProductDto deleteProductById(Integer productId) throws ProductException;
}
