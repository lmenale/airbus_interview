package com.demo.service;

import com.demo.factory.ProductValidatorFactory;
import com.demo.factory.ProductValidator;
import com.demo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* Service class for managing products.
* Demonstrates dependency injection and serialization/deserialization.
*/
public class ProductService {
  private final ObjectMapper objectMapper;
  private final List<Product> products;

  /**
   * Constructor injection of dependencies.
   * @param objectMapper The ObjectMapper instance for JSON processing
   */
  public ProductService(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      this.products = new ArrayList<>();
  }

  /**
   * Adds a new product after validation.
   * @param product The product to add
   * @return true if the product was added successfully
   */
  public boolean addProduct(Product product) {
      ProductValidator validator = ProductValidatorFactory.createValidator("default");
      if (validator.validate(product)) {
          products.add(product);
          return true;
      }
      return false;
  }

  /**
   * Saves products to a JSON file.
   * @param filename The name of the file to save to
   * @throws IOException if there's an error writing to the file
   */
  public void saveToFile(String filename) throws IOException {
      objectMapper.writeValue(new File(filename), products);
  }

  /**
   * Loads products from a JSON file.
   * @param filename The name of the file to load from
   * @throws IOException if there's an error reading the file
   */
  public void loadFromFile(String filename) throws IOException {
      Product[] loadedProducts = objectMapper.readValue(new File(filename), Product[].class);
      products.clear();
      products.addAll(Arrays.asList(loadedProducts));
  }

  public List<Product> getProducts() {
      return new ArrayList<>(products);
  }
}
