package com.demo;

import com.demo.config.ConfigurationManager;
import com.demo.model.Product;
import com.demo.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
* Main class demonstrating the usage of all components.
*/
public class Main {
  public static void main(String[] args) {
      try {
          // Demonstrate Singleton
          ConfigurationManager config = ConfigurationManager.getInstance();
          System.out.println("Using database: " + config.getDatabaseUrl());

          // Demonstrate Dependency Injection and Factory
          ObjectMapper objectMapper = new ObjectMapper();
          ProductService productService = new ProductService(objectMapper);

          // Add some products
          productService.addProduct(new Product(1L, "Laptop", 999.99));
          productService.addProduct(new Product(2L, "Mouse", 29.99));

          // Demonstrate serialization
          productService.saveToFile("products.json");

          // Demonstrate deserialization
          ProductService newService = new ProductService(objectMapper);
          newService.loadFromFile("products.json");

          // Print loaded products
          newService.getProducts().forEach(System.out::println);

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
