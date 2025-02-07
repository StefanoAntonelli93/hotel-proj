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

    // GET
    public List<Product> getProducts() { //prendo lista di dati in model/Products
        return products;
    }

    public Product getProductById(int prodId) { //prendo singolo elemento in lista di dati in model/Products
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(0, "No Items", 0));
    }

    //  POST
    public void addProduct(Product prod) {
        products.add(prod);
    }

    // PUT
    public void updateProduct(Product prod) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProdId() == prod.getProdId()) {
                products.set(i, prod); // Sostituisco l'elemento nella lista
                break;
            }
        }
    }

    // DELETE
    public void deleteProduct(int prodId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProdId() == prodId) {
                products.remove(prodId); //rimuovo prodotto dalla lista
                break;
            }
        }

    }

}
