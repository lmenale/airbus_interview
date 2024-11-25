package com.demo;

import com.demo.model.Product;
import com.demo.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
* Unit tests for the ProductService class.
*/
class ProductServiceTest {
  private ProductService productService;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
      objectMapper = new ObjectMapper();
      productService = new ProductService(objectMapper);
  }

  @Test
  void testAddValidProduct() {
      Product product = new Product(1L, "Test Product", 99.99);
      assertTrue(productService.addProduct(product));
      assertEquals(1, productService.getProducts().size());
  }

  @Test
  void testAddInvalidProduct() {
      Product product = new Product(1L, "", 99.99);
      assertFalse(productService.addProduct(product));
      assertEquals(0, productService.getProducts().size());
  }

  @Test
  void testSerializationDeserialization(@TempDir Path tempDir) throws IOException {
      // Create test data
      Product product = new Product(1L, "Test Product", 99.99);
      productService.addProduct(product);

      // Save to file
      String filename = tempDir.resolve("products.json").toString();
      productService.saveToFile(filename);

      // Create new service and load from file
      ProductService newService = new ProductService(objectMapper);
      newService.loadFromFile(filename);

      // Verify
      assertEquals(1, newService.getProducts().size());
      assertEquals("Test Product", newService.getProducts().get(0).getName());
  }
}
