package com.shop.logic.service;

import com.shop.storage.entity.Product;
import com.shop.storage.enums.OrderStatus;
import com.shop.storage.enums.ProductStatus;
import com.shop.storage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Igor on 27.06.2015.
 */
@Service(value = "productService")
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long create(Product product) {
        return productRepository.save(product);
    }

    public Long setStatus(Long productId, ProductStatus productStatus) {
        Product product = productRepository.getById(productId);
        product.setProductStatus(productStatus);
        return productRepository.update(product);
    }

    public boolean delete(Product product) {
        return productRepository.delete(product);
    }

    public List<Product> getAllProducts(int startingResult, int resultsCount) {
        return productRepository.getAllProducts(startingResult, resultsCount);
    }

    public List<Product> getProductsByName(String name,int startingResult, int resultsCount) {
        return productRepository.getProductsByName(name, startingResult, resultsCount);
    }

    public List<Product> getProductsByBrandName(String brandName, int startingResult, int resultsCount) {
        return productRepository.getProductsByBrandName(brandName, startingResult, resultsCount);
    }

    public List<Product> getProductsPriceBetween(BigDecimal low, BigDecimal high, int startingResult, int resultsCount) {
        return productRepository.getProductsPriceBetween(low, high, startingResult, resultsCount);
    }

    public Long getTotalAllProducts() {
        return productRepository.getTotalAllProducts();
    }

    public Long getTotalProductsByName(String name) {
        return productRepository.getTotalProductsByName(name);
    }

    public Long getTotalProductsByBrandName(String brandName) {
        return productRepository.getTotalProductsByBrandName(brandName);
    }

    public Long getTotalProductsPriceBetween(BigDecimal low, BigDecimal high) {
        return productRepository.getTotalProductsPriceBetween(low, high);
    }
}
