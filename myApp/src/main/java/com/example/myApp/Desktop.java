package com.example.myApp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("laptop")
public class Desktop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling with 404 bugs with desktop");
    }

}
