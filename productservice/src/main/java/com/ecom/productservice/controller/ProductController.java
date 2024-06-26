package com.ecom.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.dto.CreateProductRequestDTO;

@RestController
@RequestMapping("/products")
public class ProductController {
    //get all products
    @GetMapping("/")
    public String getAllProducts()
    {
        return "all products ..................";
    }

    @PostMapping("/")
    public String postProduct(@RequestBody CreateProductRequestDTO dto)
    {
        return "the product has been created "+dto.getName();
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId)
    {
        return "the product is ........... "+productId;
    }
}
