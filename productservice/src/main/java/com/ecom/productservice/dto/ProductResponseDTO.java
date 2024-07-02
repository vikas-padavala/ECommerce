package com.ecom.productservice.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String catagory;
    private String image;
    private Rating rating;
}