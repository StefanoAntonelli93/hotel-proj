package com.example.simpleWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // from lombok
@AllArgsConstructor // create a constructor of all attributes
@Entity // entità nel database
public class Product {

    @Id
    private int prodId;
    private String name;
    private int price;

    //costruttore vuoto chiesto da hybernate
    public Product() {

    }
}
