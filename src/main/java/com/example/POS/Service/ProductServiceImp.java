package com.example.POS.Service;

import com.example.POS.Models.Products;
import com.example.POS.Repository.ProductRepository;
import com.example.POS.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String saveProduct(Products products) {
        return productRepository.save(products).getId();
    }

    @Override
    public void createProduct(Products products) throws BaseException {
        Optional<Products> productsOptional = productRepository.findByProduct(products.getName());
        if (productsOptional.isPresent()){
            System.out.println("Same");
            throw new BaseException(BaseException.ProductAlreadyExists());
        }
        if (products.getName().isBlank()) {
            System.out.println("Name nulla");
            throw new BaseException(BaseException.ProductNameNull());
        }else {
            System.out.println("save dai");
            saveProduct(products);
        }
    }
    @Override
    public void delete(String id){
        String count = productRepository.countById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Products get(String id){
        return productRepository.findById(id).get();
    }
}
