package com.example.POS.Service;

import com.example.POS.Models.Products;
import com.example.POS.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String save(Products products) {
        return productRepository.save(products).getId();
    }


}
