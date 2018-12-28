package com.fpa.agsapipluralsight.api.product.controller;

import com.fpa.agsapipluralsight.api.BaseController;
import com.fpa.agsapipluralsight.api.exception.ProductNotFoundException;
import com.fpa.agsapipluralsight.api.product.dto.ProductDTO;
import com.fpa.agsapipluralsight.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable("id") Long productId){
        try {
            return productService.getProduct(productId);
        } catch (ProductNotFoundException e) {
            throw handleException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> listProducts(){
        return productService.listProducts();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO editProduct(@RequestBody ProductDTO productDTO){
        try {
            return productService.editProduct(productDTO);
        } catch (ProductNotFoundException e) {
            throw handleException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
