package org.example.demo_call_api_by_controller.controller;

import org.example.demo_call_api_by_controller.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    final String url_api = "http://localhost:8080/api/v1/user/products";
    @GetMapping
    public String home(Model model){
        Object[] result = restTemplate.getForObject(url_api, Object[].class);
        List<Product> list;
        list = Arrays.stream(result).map(data -> modelMapper.map(data,Product.class)).toList();
        model.addAttribute("list",list);
        return "home";
    }
}
