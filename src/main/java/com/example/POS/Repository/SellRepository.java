package com.example.POS.Repository;

import com.example.POS.Models.Products;
import com.example.POS.Models.SellId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SellRepository extends MongoRepository<SellId, String> {
    @Query("{id: ?0}")
    Optional<Products> findByProductId(String id);

    public String countById(String id);
}
