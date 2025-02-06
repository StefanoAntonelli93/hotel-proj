package com.example.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.model.Product;
import com.example.simpleWebApp.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products") // prendo prodotti da service
    public List<Product> getProducts() { // Prende tutti i prodotti
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) { // Prende un singolo prodotto per ID
        return service.getProductById(prodId);
    }

    @PostMapping("/products") // creo prodotto
    public void addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
    }
}
/*
@RestController → Permette a Spring di gestire le richieste HTTP REST.
@RequestMapping("/products") → Definisce l'endpoint base per le richieste.
@PostMapping → Mappa il metodo POST correttamente.
@RequestBody → Permette di ricevere il JSON del nuovo prodotto nel corpo della richiesta.
 */
