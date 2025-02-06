package com.example.myApp;

import org.springframework.stereotype.Component;

// creo classe sviluppatori
@Component //ogni classe è un componente
public class Dev {

    private final Computer computer;
    private String name;
    private int age;

    // @Autowired
    public Dev(Computer computer) { //inietto dipendenza con construttore
        this.computer = computer;
    }

    public int getAge() { // getter
        return age;
    }

    public void setAge(int age) { // setter
        this.age = age;
    }

    public String getName() { // getter
        return name;
    }

    public void setName(String name) { // setter
        this.name = name;
    }

    public void coding() { //creo metodo
        computer.compile();//invoco metodo laptop
        System.out.println("working on web app");

    }
}
