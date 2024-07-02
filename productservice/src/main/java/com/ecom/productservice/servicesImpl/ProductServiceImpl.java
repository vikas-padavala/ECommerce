package com.ecom.productservice.servicesImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ecom.productservice.dto.CreateProductRequestDTO;
import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;
import com.ecom.productservice.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public FakeStoreProductResponse getProductById(Integer productId) {
        // System.out.println("this it the request!!!!" + productId);
        FakeStoreProductResponse fsprdto = restTemplateBuilder.build()
                .getForEntity("https://fakestoreapi.com/products/{productId}",
                        FakeStoreProductResponse.class,
                        productId)
                .getBody();
        return fsprdto;
    }

    @Override
    public List<FakeStoreProductResponse> getAllProducts() {
        FakeStoreProductResponse[] fsprdto = restTemplateBuilder.build()
                .getForEntity("https://fakestoreapi.com/products", FakeStoreProductResponse[].class).getBody();
        return Arrays.asList(fsprdto);
    }

    @Override
    public FakeStoreProductResponse patchProduct(Integer productId, CreateProductRequestDTO dto) {
        FakeStoreProductResponse fsprdto = this.requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{productId}", dto, FakeStoreProductResponse.class, productId)
                .getBody();
        return fsprdto;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
            Class<T> responseType, Object... uriVariables) throws RestClientException {
                System.out.println("boommm!!!!!!");
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class)
                .build();
                System.out.println("boommm!!!!!!");
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        System.out.println("boommm!!!!!!");
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        System.out.println("boommm!!!!!!");
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

}
