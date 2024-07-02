package com.ecom.productservice.services;

import java.util.List;

import com.ecom.productservice.models.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    List<Product> getAllProducts();

    Product patchProduct(Integer productId, Product dto) throws Exception;

}
