package com.example.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// creo classe sviluppatori
@Component // ogni classe è un componente
public class Dev {

    private final Computer computer;
    private String name;
    private int age;

    // @Autowired
    public Dev(@Autowired Computer computer) { // inietto dipendenza con construttore
        this.computer = computer;
    }

    public void coding() { // creo metodo
        computer.compile();// invoco metodo laptop perchè @primary
        System.out.println("working on web app");

    }
}
