package com.example.POS.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Products {

    @Id
    private String id;

    private String name;

    private double price;

    private int amount;

    private String type;
}
