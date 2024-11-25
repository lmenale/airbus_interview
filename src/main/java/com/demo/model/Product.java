package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
* Represents a Product in the system.
* This class demonstrates serialization/deserialization capabilities.
*/
public class Product {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private double price;

  // Default constructor for Jackson
  public Product() {}

  public Product(Long id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
  }

  // Getters and setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }

  @Override
  public String toString() {
      return "Product{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", price=" + price +
              '}';
  }
}
