package org.example.demo_product_api.service.impl;

import org.example.demo_product_api.model.entity.Product;
import org.example.demo_product_api.repository.ProductRepository;
import org.example.demo_product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai product id "+proId));
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.findById(product.getProId()).orElseThrow(()->new NoSuchElementException("Khong ton tai product id "+product.getProId()));
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer proId) {
        productRepository.deleteById(proId);
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        return productRepository.findProductsByProNameContaining(proName);
    }
}
