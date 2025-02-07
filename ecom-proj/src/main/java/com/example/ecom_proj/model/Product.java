package com.example.ecom_proj.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;


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
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private Boolean available;
    private BigInteger quantity;
}
