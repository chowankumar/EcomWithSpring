package com.product.productcatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class ProductcatalogApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public ProductcatalogApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			dataSource.getConnection();
			System.out.println("✅ Database is connected successfully!");
		} catch (Exception e) {
			System.err.println("❌ Database connection failed: " + e.getMessage());
		}
	}
}
