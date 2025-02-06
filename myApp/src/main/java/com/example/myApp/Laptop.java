package com.example.myApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // è un componente di spring
@Primary// in caso di conflitto la classe laptop ha priorità
public class Laptop implements Computer { //laptop è un tipo di computer

    @Override
    public void compile() {
        System.out.println("Compiling with 404 bugs with laptop");
    }
}
