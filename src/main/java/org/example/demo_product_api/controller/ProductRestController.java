package org.example.demo_product_api.controller;

import jakarta.validation.Valid;
import org.example.demo_product_api.model.entity.Product;
import org.example.demo_product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/user/products")
    public ResponseEntity<List<Product>> products(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/user/products/{proId}")
    public ResponseEntity<Product> getById(@PathVariable Integer proId){
        return new ResponseEntity<>(productService.getProductById(proId),HttpStatus.OK);
    }

    @PostMapping("/admin/products")
    public ResponseEntity<?> insertProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productService.insertProduct(product),HttpStatus.OK);
    }

    @PutMapping("/admin/products")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{proId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer proId){
        productService.deleteProduct(proId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/products/searchByName/{proName}")
    public ResponseEntity<List<Product>> searchByName(@PathVariable String proName){
        return new ResponseEntity<>(productService.getProductsByName(proName), HttpStatus.OK);
    }
}
