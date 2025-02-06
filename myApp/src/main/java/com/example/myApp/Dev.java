package com.example.myApp;

import org.springframework.stereotype.Component;

// creo classe sviluppatori
@Component //ogni classe è un componente
public class Dev {

    private final Computer computer;

    // @Autowired
    public Dev(Computer computer) { //inietto dipendenza con construttore
        this.computer = computer;
    }

    public void coding() { //creo metodo
        computer.compile();//invoco metodo laptop
        System.out.println("working on web app");

    }
}
