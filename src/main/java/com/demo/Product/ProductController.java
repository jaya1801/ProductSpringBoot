package com.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable Integer id) throws ProductException{


        return productService.getProductById(id);
    }

    @PostMapping("/product")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProductDto addResource(@RequestBody ProductDto product){
        return productService.registerProduct(product);
    }

    @PutMapping("/product")
    public ProductDto replaceResource(@RequestBody ProductDto product)
    {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{productId}")
    public ProductDto deleteResource(@PathVariable("productId") Integer productId ) throws ProductException {
        return productService.deleteProductById(productId);
    }
    @PatchMapping("/product/{id}/name/{productName}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String updateResourceName(@PathVariable("id") Integer productId,@PathVariable("productName") String productName){
        return "Patch !"+productId+":"+productName;
    }




}
