package com.example.simpleWebApp.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleWebApp.model.Product;
import com.example.simpleWebApp.repository.ProductRepo;

@Service

public class ProductService {
    // creo array di prodocts

    @Autowired
    ProductRepo repo; // inietto dipendenze della repo product

    // private final List<Product> products = new ArrayList<>();
    // public ProductService() {
    // // Aggiungo gli elementi iniziali alla lista mutabile
    // products.add(new Product(1, "Iphone", 500));
    // products.add(new Product(2, "Samsung", 600));
    // products.add(new Product(3, "Oppo", 450));
    // }
    // GET
    public List<Product> getProducts() { // prendo lista di dati in model/Products
        return repo.findAll();
    }

    public Product getProductById(int prodId) { // prendo singolo elemento in lista di dati in model/Products
        return repo.findById(prodId)
                .orElse(null);

    }

    // POST
    public void addProduct(Product prod) {
        repo.save(prod);
    }

    // PUT
    public void updateProduct(Product prod) {
        repo.save(prod);

    }

    // DELETE
    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);

    }

}
