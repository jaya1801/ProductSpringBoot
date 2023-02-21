package com.demo.Product;

import com.demo.Product.ProductDto;
import com.demo.Product.ProductException;
import com.demo.Product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ProductServiceIntegrationTests {

    @Autowired
    private ProductService productService;
    @Test
    void registerProductTest() {
        ProductDto prod = new ProductDto(1,"chocolate",100.0);
        assertEquals("chocolate",this.productService.registerProduct(prod).getName());
    }
    @Test
    void getProductByIdThrowsExceptionTest() {
        assertThrows(ProductException.class,()->this.productService.getProductById(1000));
    }



    @Test
    void deleteProductByIdThrowsExceptionTest(){
        assertThrows(ProductException.class,()->this.productService.deleteProductById(1000));
    }


}
