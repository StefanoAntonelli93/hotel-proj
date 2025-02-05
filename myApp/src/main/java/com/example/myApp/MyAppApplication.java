package com.example.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

			
	// Dev dev1 = new Dev(); // creo oggetto Dev in java

	Dev dev1 = context.getBean(Dev.class); //creo oggetto in SpringBoot

	dev1.coding(); //invoco metodo 

	}

}
