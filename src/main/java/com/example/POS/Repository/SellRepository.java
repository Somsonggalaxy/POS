package com.example.POS.Repository;

import com.example.POS.Models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellRepository extends MongoRepository<Products, String> {

}
