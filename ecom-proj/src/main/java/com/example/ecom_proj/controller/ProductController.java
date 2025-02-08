package com.example.ecom_proj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin // condivisione risorse con frontend CORS
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello world, its me ,the controller.";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products/{Id}") // non ritorna il dato ma la risposta
    public ResponseEntity<Product> getProductById(@PathVariable int Id) {

        Product product = service.getProductById(Id);

        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products") // creo prodotto
    public void addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
    }

    @PutMapping("/products") // modifico prodotto
    public void updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{Id}") // eleimino prodotto
    public void deleteProduct(@PathVariable int Id) {
        service.deleteProduct(Id);
    }

    // cercare nel database tramite keyword
    // @GetMapping("/products/search")
    // public ResponseEntity<List<Product>> searchProducts(@RequestParam String
    // keyword) {

    // List<Product> products = service.searchProducts(keyword);
    // System.out.println("searching with " + keyword);
    // return new ResponseEntity<>(products, HttpStatus.OK);
    // }

}
