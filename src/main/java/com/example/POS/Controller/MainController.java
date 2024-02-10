package com.example.POS.Controller;

import com.example.POS.Models.Products;
import com.example.POS.Repository.ProductRepository;
import com.example.POS.Service.ProductService;
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

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Products products){
        productService.save(products);
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

    @PutMapping("/products/{id}")
    public Products putProductsById(@PathVariable("id") String id, @RequestBody Products newProducts){
        return productRepository.findById(id)
                .map(products -> {
                    products.setName(newProducts.getName());
                    products.setPrice(newProducts.getPrice());
                    products.setAmount(newProducts.getAmount());
                    products.setType(newProducts.getType());
                    return productRepository.save(products);
                })
                .orElseGet(() -> {
                    newProducts.setId(id);
                    return productRepository.save(newProducts);
                });
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delelteProductById(@PathVariable("id") String id){
        Optional<Products> products = productRepository.findById(id);
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Delete product id "+ id + " successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Not found product.", HttpStatus.NOT_FOUND);
        }
    }


}
