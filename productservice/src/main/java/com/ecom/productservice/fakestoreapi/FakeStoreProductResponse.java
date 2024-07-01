package com.ecom.productservice.fakestoreapi;

import lombok.Data;

@Data
public class FakeStoreProductResponse {
    Integer id;
    String title;
    Double price;
    String description;
    String catagory;
    String image;
    Rating rating;
}
