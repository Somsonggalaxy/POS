package com.example.POS.Service;

import com.example.POS.Models.Products;
import com.example.POS.exception.BaseException;

public interface ProductService {
    String save(Products products);

    void createProduct(Products products) throws BaseException;

}
