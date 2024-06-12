package org.example.demo_call_api_by_controller.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Integer proId;
    private String proName;
    private String producer;
    private Integer yearMaking;
    private Double price;

    public String formatPrice(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(price);
    }
}
