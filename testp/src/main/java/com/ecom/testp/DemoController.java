package com.ecom.testp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String helloWorld()
    {
        return "Hello World !!!, comon baby, lets rock and roll";
    }
    
}
