# Design Patterns Demo Project

This project demonstrates the implementation of several design patterns in Java, including Singleton, Factory, Dependency Injection, and MVC-like structure.

## Design Patterns Implemented

### 1. Singleton Pattern (ConfigurationManager)
The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

### 2. Factory Pattern (ProductValidatorFactory)
The Factory pattern provides an interface for creating objects but lets subclasses decide which class to instantiate.

### 3. Dependency Injection (ProductService)
DI pattern implements inversion of control for resolving dependencies.

### 4. MVC-like Structure
- **Model**: Product class representing data
- **Service**: ProductService handling business logic
- **Controller**: (if applicable) handling HTTP requests

## Project Setup

### Prerequisites
- Java JDK 11 or higher
- Maven

### Building the Project
```bash
mvn clean install
mvn exec:java
```

### Running Tests
```bash
mvn test
```

## Usage Examples

### Creating a Product
```java
// Create dependencies
ProductRepository repository = new ProductRepository();
ProductValidator validator = ProductValidatorFactory.createValidator("electronics");
// Initialize service with dependencies
ProductService productService = new ProductService(repository, validator);
// Create and save product
Product product = new Product("Laptop", "electronics", 999.99);
productService.saveProduct(product);
```

### Accessing Configuration
```java
ConfigurationManager config = ConfigurationManager.getInstance();
String setting = config.getSetting("key");
```

## Project Structure
```
src/
├── main/java/com/demo/
│   ├── config/
│   │   └── ConfigurationManager.java
│   ├── factory/
│   │   └── ProductValidator.java
│   │   └── ProductValidatorFactory.java
│   ├── model/
│   │   └── Product.java
│   ├── service/
│   │   └── ProductService.java
│   └── Main.java
└── test/java/com/demo/
  └── ProductServiceTest.java
```

## Benefits of Used Design Patterns

1. **Singleton Pattern**
   - Ensures single instance of configuration
   - Provides global access point
   - Controls resource usage

2. **Factory Pattern**
   - Encapsulates object creation
   - Provides flexibility in creating different validators
   - Makes code more maintainable

3. **Dependency Injection**
   - Reduces coupling between classes
   - Improves testability
   - Makes code more modular

4. **MVC-like Structure**
   - Separates concerns
   - Improves maintainability
   - Makes code more organized

## UML diagram

[uml diagrams](src/docs/diagrams.md)

Realized using Mermaid.
