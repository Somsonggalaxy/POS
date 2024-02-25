package com.example.POS.controller;

import com.example.POS.Models.Products;
import com.example.POS.Models.SellId;
import com.example.POS.Repository.ProductRepository;
import com.example.POS.Repository.SellRepository;
import com.example.POS.Service.ProductService;
import com.example.POS.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
public class MainController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellRepository sellRepository;
    @Autowired
    ProductService productService;

//    @PostMapping("/addProduct")
//    public void addProduct(@RequestBody Products products) {
//        productService.saveProduct(products);
//    }
//
//    @GetMapping("/products")
//    public ResponseEntity<?> getAllProducts() {
//        List<Products> products = productRepository.findAll();
//        if (!products.isEmpty()) {
//            return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No products available", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<?> getProductsById(@PathVariable("id") String id) {
//        Optional<Products> products = productRepository.findById(id);
//        if (products.isPresent()) {
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Products not found", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/products/{id}")
//    public Products putProductsById(@PathVariable("id") String id, @RequestBody Products newProducts) {
//        return productRepository.findById(id)
//                .map(products -> {
//                    products.setName(newProducts.getName());
//                    products.setPrice(newProducts.getPrice());
//                    products.setAmount(newProducts.getAmount());
//                    products.setType(newProducts.getType());
//                    return productRepository.save(products);
//                })
//                .orElseGet(() -> {
//                    newProducts.setId(id);
//                    return productRepository.save(newProducts);
//                });
//    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delelteProductById(@PathVariable("id") String id) {
        Optional<Products> products = productRepository.findById(id);
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Delete product id " + id + " successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Not found product.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @ModelAttribute
    @GetMapping("/stock")
    public String showStockPage(Model model) {
        List<Products> productsList = productRepository.findAll();
        model.addAttribute("products", productsList);
        return "stock";
    }

    @PostMapping("/stock")
    public String addProducts(@ModelAttribute Products p) throws BaseException {
        productService.createProduct(p);
        return "stock";
    }

    @GetMapping("/stock/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) throws BaseException {
        productService.delete(id);
        return "redirect: /stock";
    }
    @ModelAttribute
    @PostMapping("/sell")
    public String searchProductById(@RequestBody SellId sellId){
        productService.createSellId(sellId);
        return "sell";
    }

    @ModelAttribute
    @GetMapping("/sell")
    public String getProductSell(Model model){
        List<SellId> productsList = sellRepository.findAll();
        model.addAttribute("productList", productsList);
        return ("sell");
    }


}

