package com.dicky.barcodeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BarcodeApiApplication{


	public static void main(String[] args) {
		SpringApplication.run(BarcodeApiApplication.class, args);
	}

}
