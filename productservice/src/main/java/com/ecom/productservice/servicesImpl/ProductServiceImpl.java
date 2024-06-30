package com.ecom.productservice.servicesImpl;

import org.springframework.stereotype.Service;

import com.ecom.productservice.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String getProductById(Integer productId) {
        return "hawk tuah spit on that thing which is having the product Id "+productId;
    }

}
