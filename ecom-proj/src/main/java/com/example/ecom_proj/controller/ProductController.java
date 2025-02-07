package com.example.ecom_proj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello world, its me ,the controller.";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
    
    @GetMapping("/products/{Id}")
    public Product getProductById(@PathVariable int Id) {
        return service.getProductById(Id);
    } // Prende un singolo prodotto per ID

    @PostMapping("/products") // creo prodotto
    public void addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
    }

    @PutMapping("/products") // modifico prodotto
    public void updateProduct(@RequestBody Product prod) {
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{Id}") //eleimino prodotto
    public void deleteProduct(@PathVariable int Id) {
        service.deleteProduct(Id);
    }
      

 
}
