package com.ecom.productservice.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;
import com.ecom.productservice.fakestoreapi.FakeStoreProductRequest;
import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.models.Rating;

public class ProductMapper {
    public static Product getProductFromFakeStoreProduct(FakeStoreProductResponse fsprdto) {
        Product product = new Product();
        product.setId(fsprdto.getId());
        product.setTitle(fsprdto.getTitle());
        product.setPrice(fsprdto.getPrice());
        product.setDescription(fsprdto.getDescription());
        product.setCatagory(fsprdto.getCatagory());
        product.setImage(fsprdto.getImage());
        // Rating rating = new Rating();
        // rating.setCount(fsprdto.getRating().getCount());
        // rating.setRate(fsprdto.getRating().getRate());
        // product.setRating(rating);
        return product;
    }

    public static List<Product> getProductListFromFakeStoreList(FakeStoreProductResponse[] fsprdto) {
        List<Product> products = new ArrayList<Product>();
        for (FakeStoreProductResponse fspr : fsprdto) {
            products.add(getProductFromFakeStoreProduct(fspr));
        }
        return products;
    }

    public static FakeStoreProductRequest getFakeStoreProductRequestFromProduct(Product product) {
        FakeStoreProductRequest fspr = new FakeStoreProductRequest();
        fspr.setTitle(product.getTitle());
        fspr.setPrice(product.getPrice());
        fspr.setDescription(product.getDescription());
        fspr.setImage(product.getImage());
        fspr.setCatagory(product.getCatagory());
        return fspr;
    }

    public static ProductResponseDTO getProductResponseDTOFromProduct(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCatagory(product.getCatagory());
        productResponseDTO.setImage(product.getImage());
        return productResponseDTO;
    }

    public static List<ProductResponseDTO> getProductResponseDTOsFromProducts(List<Product> products) {
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<ProductResponseDTO>();
        for (Product product : products) {
            productResponseDTOs.add(getProductResponseDTOFromProduct(product));
        }
        return productResponseDTOs;
    }

    public static Product getProductFromProductRequestDTO(ProductRequestDTO dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        product.setPrice(dto.getPrice());
        return product;
    }
}
