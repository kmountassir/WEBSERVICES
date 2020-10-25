package org.iga.product;

import org.iga.product.model.Product;
import org.iga.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration config) {
		return args -> {
			config.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "Computer Desktop", 1000));
			productRepository.save(new Product(null, "Printer Epson", 850));
			productRepository.save(new Product(null, "MacBook", 18000));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
