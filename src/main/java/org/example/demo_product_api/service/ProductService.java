package org.example.demo_product_api.service;

import org.example.demo_product_api.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer proId);
    Product insertProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer proId);
    List<Product> getProductsByName(String proName);
}
