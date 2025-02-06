package com.example.simpleWebApp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simpleWebApp.model.Product;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(01, "Iphone", 500),
            new Product(02, "Samsung", 600),
            new Product(03, "Oppo", 450)); // prodId name price

    public List<Product> getProducts() { //prendo lista di dati in model/Products
        return products;
    }
}
