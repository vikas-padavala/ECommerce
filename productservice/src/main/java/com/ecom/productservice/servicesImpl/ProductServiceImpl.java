package com.ecom.productservice.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;
import com.ecom.productservice.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public FakeStoreProductResponse getProductById(Integer productId) {
        // System.out.println("this it the request!!!!" + productId);
        FakeStoreProductResponse fsprdto = restTemplateBuilder.build()
                .getForEntity("https://fakestoreapi.com/products/{productId}",
                        FakeStoreProductResponse.class,
                        productId)
                .getBody();
        return fsprdto;
    }

    @Override
    public List<FakeStoreProductResponse> getAllProducts() {
        FakeStoreProductResponse[] fsprdto = restTemplateBuilder.build()
                .getForEntity("https://fakestoreapi.com/products", FakeStoreProductResponse[].class).getBody();
        return Arrays.asList(fsprdto);
    }

}
