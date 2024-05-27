package com.example.salary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalaryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {

  }
}
