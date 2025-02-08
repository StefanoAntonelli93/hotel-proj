package com.example.ecom_proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    // GET
    public List<Product> getAllProducts() { // metodo che ritorna tutti i prodotti
        return repo.findAll();
    }

    public Product getProductById(int Id) { // prendo singolo elemento in lista di dati in model/Products
        return repo.findById(Id)
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
    public void deleteProduct(int Id) {
        repo.deleteById(Id);

    }

    // // cercare tramite keyword
    // public List<Product> searchProducts(String keyword) {
    // return repo.searchProducts(keyword);
    // }

}
