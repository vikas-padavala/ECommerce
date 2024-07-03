package com.ecom.productservice.fakeStoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;

@Component
public class FakeStoreClient {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;


    public FakeStoreProductResponse getProductById(Integer productId) {
        return restTemplateBuilder.build()
                .getForEntity("https://fakestoreapi.com/products/{productId}",
                        FakeStoreProductResponse.class,
                        productId)
                .getBody();
    }
}
