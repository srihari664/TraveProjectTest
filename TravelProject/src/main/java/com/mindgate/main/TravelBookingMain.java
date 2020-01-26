package com.mindgate.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.mindgate")
@SpringBootApplication
public class TravelBookingMain {
	
	public static void main(String[] args) {
		
		SpringApplication.run(TravelBookingMain.class, args);
		

	}

}
