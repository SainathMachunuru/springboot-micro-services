package com.msng.catalogservice.service;

import com.msng.catalogservice.entity.Product;
import com.msng.catalogservice.entity.ProductInventoryResponse;
import com.msng.catalogservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.msng.catalogservice.service.InventoryServiceClient;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final InventoryServiceClient inventoryServiceClient;

    @Autowired
    public ProductService(ProductRepository productRepository, InventoryServiceClient inventoryServiceClient) {
        this.productRepository = productRepository;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductByCode(String code) {
        Optional<Product> productOptional = productRepository.findByCode(code);
        if(productOptional.isPresent()) {
            log.info("Fetching inventory level for product_code: "+code);
            Optional<ProductInventoryResponse> productInventoryResponse  = inventoryServiceClient.getProductInventoryByCode(code);
            log.info("Inventory of given product: ", productInventoryResponse.toString());
//            ResponseEntity<ProductInventoryResponse> itemResponseEntity =
//                    restTemplate.getForEntity("http://inventory-service/api/inventory/{code}",
//                            ProductInventoryResponse.class,
//                            code);
//            if(itemResponseEntity.getStatusCode() == HttpStatus.OK) {
//                Integer quantity = itemResponseEntity.getBody().getAvailableQuantity();
//                log.info("Available quantity: "+quantity);
////                productOptional.get().setInStock(quantity> 0);
//            } else {
//                log.error("Unable to get inventory level for product_code: "+code +
//                        ", StatusCode: "+itemResponseEntity.getStatusCode());
//            }
        }
        return productOptional;
    }
}
