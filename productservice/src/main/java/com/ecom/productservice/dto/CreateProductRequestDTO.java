package com.ecom.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String name;
    private String catagory;
    private String imageURL;
    private Double price;
}
