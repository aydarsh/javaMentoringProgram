package com.rostertwo.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringdataApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringdataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			log.info("-------------------------------------------");
			log.info("CREATE: Created customers with save(entity)");
			log.info("-------------------------------------------");
			log.info("");

			// fetch all customers
			log.info("READ: Customers found with findAll():");
			log.info("-------------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Customer> customer = repository.findById(1L);

			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			customer.ifPresent((s) -> log.info(s.toString()));
			log.info("");

			// update customer firstName and lastName
			customer.ifPresent((s) -> {
				s.setFirstName("Aidar");
				s.setLastName("Sharafiev");
			});
			repository.save(customer.get());
			log.info("UPDATE: Updated customer found with findById(1L):");
			log.info("-------------------------------------------------");
			customer = repository.findById(1L);
			customer.ifPresent((s) -> log.info(s.toString()));
			log.info("");

			// delete customer by id with deleteById(ID id)
			repository.deleteById(2L);
			log.info("DELETE: Delete customers with deleteById(2L):");
			log.info("---------------------------------------------");
			for (Customer customer2 : repository.findAll()) {
				log.info(customer2.toString());
			}
			log.info("");
		};
	}
}
