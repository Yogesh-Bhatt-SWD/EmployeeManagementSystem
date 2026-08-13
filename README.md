# Employee Management System

A backend application for managing employee information using **Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, and REST APIs**.

## Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **API:** REST APIs
* **ORM:** Hibernate / JPA
* **Database:** MySQL
* **Build Tool:** Maven
* **Testing/API Tool:** Postman
* **Version Control:** Git & GitHub

## Features

* Employee CRUD operations
* Search employees by name
* Find employees within a salary range
* Salary increment using percentage-based business logic
* Department-related employee operations
* Employee statistics such as total, average, highest, and lowest salary
* RESTful API architecture

## Project Structure

```text
src/main/java/
└── com.Company.EmployeeManagementSystem
    ├── controller
    ├── service
    ├── repository
    ├── entity
    ├── dto
    └── ...
```

## API Examples

### Create Employee

```http
POST /employees
```

### Get All Employees

```http
GET /employees
```

### Search Employee by Name

```http
GET /employees/search?name={name}
```

### Find Employees by Salary Range

```http
GET /employees/salary?min={min}&max={max}
```

### Increment Employee Salary

```http
PATCH /employees/{id}/salary
```

## Database

The application uses **MySQL** for persistent employee data and **Spring Data JPA/Hibernate** for database interaction.

## Learning Goals

This project is being developed to strengthen practical understanding of:

* Spring Boot backend development
* REST API design
* Layered architecture
* JPA/Hibernate
* Database operations
* DTO-based API design
* Business logic implementation
* Git and GitHub workflow

## Future Improvements

* Spring Security authentication and authorization
* Unit and integration testing
* API documentation with Swagger/OpenAPI
* Global exception handling improvements
* Pagination and sorting
