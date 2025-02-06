package com.example.simpleWebApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simpleWebApp.model.Product;

@Service

public class ProductService {
//creo array di prodocts 

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Aggiungo gli elementi iniziali alla lista mutabile
        products.add(new Product(1, "Iphone", 500));
        products.add(new Product(2, "Samsung", 600));
        products.add(new Product(3, "Oppo", 450));
    }

//creo metodi GET
    public List<Product> getProducts() { //prendo lista di dati in model/Products
        return products;
    }

    public Product getProductById(int prodId) { //prendo singolo elemento in lista di dati in model/Products
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(0, "No Items", 0));
    }

// creo metodi POST
    public void addProduct(Product prod) {
        products.add(prod);
    }
}
