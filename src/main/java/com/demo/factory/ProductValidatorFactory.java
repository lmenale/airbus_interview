package com.demo.factory;

import com.demo.model.Product;

/**
* Basic validator implementation
*/
class BasicProductValidator implements ProductValidator {
  @Override
  public boolean validate(Product product) {
      return product != null && product.getName() != null && !product.getName().isEmpty();
  }
}

/**
* Premium validator implementation with additional checks
*/
class PremiumProductValidator implements ProductValidator {
  @Override
  public boolean validate(Product product) {
      return product != null && 
             product.getName() != null && 
             !product.getName().isEmpty() && 
             product.getPrice() > 0;
  }
}

/**
* Factory class for creating different types of validators.
* Demonstrates the Factory pattern.
*/
public class ProductValidatorFactory {
  /**
   * Creates a validator based on the specified type.
   * @param type The type of validator to create
   * @return A ProductValidator instance
   */
  public static ProductValidator createValidator(String type) {
      return switch (type.toLowerCase()) {
          case "basic", "default" -> new BasicProductValidator();
          case "premium" -> new PremiumProductValidator();
          default -> throw new IllegalArgumentException("Unknown validator type: " + type);
      };
  }
}
