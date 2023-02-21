package com.demo.Product;


import com.demo.Product.ProductDto;
import com.demo.Product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void init(){
        productRepository.addProduct(new ProductDto(1,"chocolate",100.0));
    }
    @Test
    public void deleteProductTest(){
        ProductDto deletedProduct= productRepository.deleteProduct(1);
        assertEquals("chocolate",deletedProduct.getName());
    }


}
