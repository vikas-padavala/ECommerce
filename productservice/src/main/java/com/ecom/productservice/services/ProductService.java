package com.ecom.productservice.services;

import java.util.List;

import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;

public interface ProductService {
    FakeStoreProductResponse getProductById(Integer productId);

    List<FakeStoreProductResponse> getAllProducts();
}
