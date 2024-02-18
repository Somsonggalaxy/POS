package com.example.POS.Repository;

import com.example.POS.Models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {
    @Query("{name: ?0}")
    Optional<Products> findByProduct(String name);

    public String countById(String id);

}
