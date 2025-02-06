package com.example.simpleWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // from lombok
@AllArgsConstructor // create a constructor
public class Product {

    private int prodId;
    private String name;
    private int price;
}
