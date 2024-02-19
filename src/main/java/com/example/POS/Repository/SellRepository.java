package com.example.POS.Repository;

import com.example.POS.Models.Products;
import com.example.POS.Models.SellProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends MongoRepository<SellProducts, String> {

}
