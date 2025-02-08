package com.example.ecom_proj.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //classe come entità del database
@Data // Lombok crea getter e setter automaticamente
@AllArgsConstructor // creo costruttore per tutti i campi
@NoArgsConstructor
public class Product {
    @Id // id è la PK della tabella Product
    @Column(name = "PROD_ID") // Assicura che Hibernate usi la colonna corretta
    private int Id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") //cambio formato data
    private Date releaseDate;
    private Boolean available;
    private BigInteger quantity;
    
}
