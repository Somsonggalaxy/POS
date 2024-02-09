package com.example.POS.Controller;

import com.example.POS.Models.Products;
import com.example.POS.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Products products){
        productRepository.save(products);
    }

}
