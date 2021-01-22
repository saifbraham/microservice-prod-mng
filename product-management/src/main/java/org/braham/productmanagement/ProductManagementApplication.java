package org.braham.productmanagement;

import org.braham.productmanagement.model.entity.Product;
import org.braham.productmanagement.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){

		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
			getAllProduct().stream().forEach(product -> {
				productRepository.save(product);
			});
		};
	}

	public static List<Product> getAllProduct(){
		return Stream.of(

				new Product(null,"PC-Dell","ref123"),
				new Product(null,"PC-LENOVO",26,1450.50,"ref659"),
				new Product(null,"SMART-TV",65,800.75,"ref777")
		).collect(Collectors.toList());
	}

}
