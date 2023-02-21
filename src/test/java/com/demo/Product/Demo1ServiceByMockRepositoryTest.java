package com.demo.Product;


import com.demo.Product.ProductDto;
import com.demo.Product.ProductException;
import com.demo.Product.ProductRepository;
import com.demo.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Demo1ServiceByMockRepositoryTest {

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @Test
    public void testServiceWithOutActualRepository() throws ProductException {
        given(this.productRepository.getProduct(100))
                .willReturn(new ProductDto(100,"chocolate", 100.0));
        assertEquals("chocolate",productService.getProductById(100).getName());
    }

    @Test
    public void testGetProductThrowsExceptionTest() throws ProductException{

        given(this.productRepository.getProduct(200))
                .willReturn(null);
        assertThrows(ProductException.class,()->productService.getProductById(200));
    }






}
