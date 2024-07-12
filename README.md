# Student API

This project is a RESTful API for managing students and their grades. The API is built using Spring Boot and uses PostgreSQL as the database. Swagger is integrated for API documentation.

## Table of Contents
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)

## Getting Started

### Prerequisites
- Java 17 or later
- Maven 3.6.0 or later
- PostgreSQL 12 or later

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/student-api.git
    cd student-api
    ```

2. Update the `application.properties` file with your PostgreSQL database credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/zyferadb
    spring.datasource.username=postgres
    spring.datasource.password=yourpassword
    ```

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## API Documentation

Swagger UI is available at `/swagger-ui.html` and the OpenAPI documentation can be accessed at `/v3/api-docs`.

## Project Structure

The project follows a typical Spring Boot structure:

- `config`: Contains Swagger configuration.
- `controller`: Contains the REST controllers.
- `entity`: Contains the JPA entities.
- `repository`: Contains the JPA repositories.
- `service`: Contains the service layer.

