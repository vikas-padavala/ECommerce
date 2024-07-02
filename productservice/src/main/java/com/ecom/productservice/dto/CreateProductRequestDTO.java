package com.ecom.productservice.dto;

import com.ecom.productservice.fakestoreapi.Rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String image;
    private Double price;
    private Rating rating;
    private String category;
}
