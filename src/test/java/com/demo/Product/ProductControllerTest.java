package com.demo.Product;

import com.demo.Product.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void init(){
        this.restTemplate.postForObject("http://localhost:" + port + "/v1/product",new ProductDto(1,"Icecream",250.0),ProductDto.class);
    }
    /*@Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/",
                String.class)).contains("Welcome to my demo spring boot application !");
    }*/

    @Test
    public void getProductByIdTest() throws Exception {
        ProductDto foundProduct =this.restTemplate.getForObject("http://localhost:" + port + "/v1/product/1", ProductDto.class);
        assertEquals("Icecream",foundProduct.getName());
    }

    @Test
    public void getProductByIdExceptionTest() throws Exception {
        String productExceptionMessage =this.restTemplate.getForObject("http://localhost:" + port + "/v1/product/2", String.class);
        assertEquals("Product Id does not exists.",productExceptionMessage);
    }




}
