package com.example.POS.Service;

import com.example.POS.Models.Products;
import com.example.POS.Models.SellProducts;
import com.example.POS.exception.BaseException;

public interface ProductService {
    String saveProduct(Products products);

    void createProduct(Products products) throws BaseException;
    void delete(String id) throws BaseException;

    String saveSoldProducts(SellProducts sellProducts);

    void createSoldProduct(SellProducts sellProducts) throws BaseException;
}
