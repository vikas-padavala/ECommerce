package com.ecom.productservice.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;
import com.ecom.productservice.mapper.ProductMapper;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // get all products
    @GetMapping("/")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> data = productService.getAllProducts();
        return ProductMapper.getProductResponseDTOsFromProducts(data);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Integer productId) {
        Product product = productService.getProductById(productId);
        if (Objects.isNull(product)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<String, String>();
        headersMap.add("class-name", "integrating API's");
        return new ResponseEntity<ProductResponseDTO>(ProductMapper.getProductResponseDTOFromProduct(product),
                headersMap, HttpStatus.OK);
    }

    @PostMapping("/")
    public ProductResponseDTO postProduct(@RequestBody ProductRequestDTO dto) {
        return null;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> patchProduct(@PathVariable("productId") Integer productId,
            @RequestBody ProductRequestDTO dto) throws Exception {
        Product data = productService.patchProduct(productId, ProductMapper.getProductFromProductRequestDTO(dto));
        return new ResponseEntity<ProductResponseDTO>(ProductMapper.getProductResponseDTOFromProduct(data), HttpStatus.ACCEPTED);
    }
}
