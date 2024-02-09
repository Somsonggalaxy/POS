package com.example.POS.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Products {

    @Id
    private String id;

    private String name;

    private double price;

    private int amount;
}
