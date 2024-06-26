package com.ecom.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catagories")
public class CatagoryController {

    @GetMapping("/")
    public String getAllCatagorieString() {
        return "All catagories";
    }

}
