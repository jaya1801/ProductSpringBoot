package com.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto registerProduct(ProductDto newProduct) {

        return productRepository.addProduct(newProduct);
    }

    @Override
    public ProductDto getProductById(Integer productId)throws ProductException {
        ProductDto foundProduct = productRepository.getProduct(productId);
        if(foundProduct == null)
            throw new ProductException("Product Id does not exists.");

        return foundProduct;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {

        return productRepository.updateProduct(product);
    }

    @Override
    public ProductDto deleteProductById(Integer productId)throws ProductException {
        ProductDto foundProduct = productRepository.getProduct(productId);
        if(foundProduct==null)
            throw new ProductException("Product couldn't be deleted, Id not found: "+productId);
        return productRepository.deleteProduct(productId);
    }

}
