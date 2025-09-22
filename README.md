# 🐾 🚗 Spring Exception Handling Demo

This project demonstrates how to handle exceptions in a Spring Boot REST 
API using both local controller-specific and global exception handlers.

## 🌟 Features
- Two example controllers:
  - AnimalController 🐶 – manages animal endpoints
  - CarController 🚗 – manages car endpoints

- Global exception handling using @RestControllerAdvice
- JSON error responses containing:
  - errorMessage – descriptive message of the error
  - instant – timestamp of when the error occurred ⏰
- Controller-level exception handlers for specific use cases
- Unit tests with MockMvc ✅

## ⚡ How It Works
### Controller-level exceptions
Each controller handles IllegalArgumentException locally to return 400 
Bad Request with a JSON response including a timestamp

### Global exception handling
**GlobalStandardExceptionHandler** handles:

NullPointerException → 500 Internal Server Error 💥

IllegalArgumentException → 400 Bad Request

Other exceptions → 500 Internal Server Error ⚠️

**GlobalExceptionHandler** handles: 

NoSuchElementException → 404 Not Found 🛑

## Testing
Tests assert HTTP status codes, JSON response structure, and presence of 
the instant timestamp using MockMvc 🔍
> mvn test

## 🚀 Getting Started
Clone the repository:
> git clone <your-repo-url>  
> cd Spring_Exception_Handling

## Build and run:
> mvn spring-boot:run

### Test the endpoints:
> GET http://localhost:8080/api/animals/dog      # 200 OK ✅  
> GET http://localhost:8080/api/animals/cat      # 400 Bad Request 🛑  
> GET http://localhost:8080/api/cars/porsche     # 200 OK ✅  
> GET http://localhost:8080/api/cars/opel        # 400 Bad Request 🛑

## 📌 Summary
Centralized exception handling reduces boilerplate code ✨

JSON responses provide clear, consistent error information 📄

Tested using MockMvc for predictable API behavior ✅