package com.ecom.productservice.models;

import java.util.Date;

import lombok.Data;

@Data
public class BaseModel {
    private Integer id;
    private String createdBy;
    private Date createdAt;
    private Boolean isDeleted;
}
