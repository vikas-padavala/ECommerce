package com.ecom.productservice.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.dto.CreateProductRequestDTO;
import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;
import com.ecom.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // get all products
    @GetMapping("/")
    public List<FakeStoreProductResponse> getAllProducts() {
        List<FakeStoreProductResponse> data = productService.getAllProducts();
        return data;
    }


    @GetMapping("/{productId}")
    public ResponseEntity<FakeStoreProductResponse> getProductById(@PathVariable("productId") Integer productId) {
        FakeStoreProductResponse data = productService.getProductById(productId);
        if (Objects.isNull(data)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<String, String>();
        headersMap.add("class-name", "integrating API's");
        return new ResponseEntity<FakeStoreProductResponse>(data,headersMap, HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping("/")
    public String postProduct(@RequestBody CreateProductRequestDTO dto) {
        return "the product has been created " + dto.getName();
    }
}
