package com.ecom.productservice.servicesImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.ecom.productservice.fakeStoreClient.FakeStoreClient;
import com.ecom.productservice.fakestoreapi.FakeStoreProductRequest;
import com.ecom.productservice.fakestoreapi.FakeStoreProductResponse;
import com.ecom.productservice.mapper.ProductMapper;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.ProductService;
import com.ecom.productservice.utility.HttpUtil;

@Service
public class ProductServiceImpl implements ProductService {

        @Autowired
        private FakeStoreClient fakeStoreClient;

        @Autowired
        RestTemplateBuilder restTemplateBuilder;

        @Override
        public Product getProductById(Integer productId) {
                FakeStoreProductResponse fsprdto = fakeStoreClient.getProductById(productId);
                return ProductMapper.getProductFromFakeStoreProduct(fsprdto);
        }

        @Override
        public List<Product> getAllProducts() {
                FakeStoreProductResponse[] fsprdto = restTemplateBuilder.build()
                                .getForEntity("https://fakestoreapi.com/products", FakeStoreProductResponse[].class)
                                .getBody();
                return ProductMapper.getProductListFromFakeStoreList(fsprdto);
        }

        @Override
        public Product patchProduct(Integer productId, Product product) throws Exception {
                Product exsistingProduct = getProductById(productId);
                if (Objects.isNull(exsistingProduct)) {
                        throw new Exception("Product does not exists");
                }
                exsistingProduct.setTitle(product.getTitle());
                exsistingProduct.setPrice(product.getPrice());
                exsistingProduct.setDescription(product.getDescription());
                exsistingProduct.setImage(product.getImage());
                exsistingProduct.setCatagory(product.getCatagory());

                FakeStoreProductRequest fspr = ProductMapper.getFakeStoreProductRequestFromProduct(exsistingProduct);
                FakeStoreProductResponse fsprdto = HttpUtil.requestForEntity(restTemplateBuilder, HttpMethod.PATCH,
                                "https://fakestoreapi.com/products/{productId}", fspr, FakeStoreProductResponse.class,
                                productId)
                                .getBody();
                return ProductMapper.getProductFromFakeStoreProduct(fsprdto);
        }
}
