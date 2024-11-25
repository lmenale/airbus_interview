package com.demo.factory;

import com.demo.model.Product;

/**
* Interface for different types of product validators
*/
public interface ProductValidator {
  boolean validate(Product product);
}
