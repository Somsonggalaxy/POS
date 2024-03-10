package com.example.POS.Repository;

import com.example.POS.Models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForSearchRepo extends MongoRepository<Products, String> {
}
