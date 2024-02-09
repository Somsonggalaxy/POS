package com.example.POS.Controller;

import com.example.POS.Models.Products;
import com.example.POS.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Products products){
        productRepository.save(products);
    }
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        List<Products> products = productRepository.findAll();
        if (!products.isEmpty()){
            return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No products available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable("id") String id){
        Optional<Products> products = productRepository.findById(id);
        if (products.isPresent()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Products not found", HttpStatus.NOT_FOUND);
        }
    }

}
