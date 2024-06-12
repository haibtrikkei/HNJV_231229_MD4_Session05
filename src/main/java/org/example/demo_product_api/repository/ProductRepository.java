package org.example.demo_product_api.repository;

import org.example.demo_product_api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductsByProNameContaining(String proName);
}
