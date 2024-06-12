package org.example.demo_product_api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(nullable = false,length = 100)
    private String proName;
    @Column(nullable = false,length = 100)
    private String producer;
    @Min(value = 0)
    private Integer yearMaking;
    @Min(value = 0)
    private Double price;
}
