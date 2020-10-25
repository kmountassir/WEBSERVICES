package org.iga.customer;

import org.iga.customer.model.Customer;
import org.iga.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration
	config){
	 return args -> {
	 config.exposeIdsFor(Customer.class);
	 customerRepository.save(new Customer(null,"enset","contact@enset-media.ma"));
	 customerRepository.save(new Customer(null,"ibm","contact@ibm.ma"));
	 customerRepository.save(new Customer(null,"iga","contact@iga.ma"));
	 customerRepository.findAll().forEach(System.out::println);
	 }; 
	}
}
