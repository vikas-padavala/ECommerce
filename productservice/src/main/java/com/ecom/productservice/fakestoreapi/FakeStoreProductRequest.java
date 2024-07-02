package com.ecom.productservice.fakestoreapi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakeStoreProductRequest {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String catagory;
}
