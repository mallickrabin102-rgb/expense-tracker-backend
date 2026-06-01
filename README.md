# Expense Tracker Backend

A Spring Boot REST API for managing expenses with secure user authentication. This project allows users to register, log in, and perform expense management operations using a MySQL database.

## Features

* User Registration
* User Login
* BCrypt Password Hashing
* Create Expense
* Get All Expenses
* Get Expenses By User
* Get Expenses By Category
* Get Expenses By Title
* Get Expenses Above a Specific Amount
* Update Expense
* Delete Expense
* Spring Data JPA Integration
* MySQL Database Connectivity
* RESTful API Design

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security (BCrypt)
* MySQL
* Maven
* Git & GitHub

## API Endpoints

### Authentication

| Method | Endpoint  | Description         |
| ------ | --------- | ------------------- |
| POST   | /register | Register a new user |
| POST   | /login    | Login user          |

### Expenses

| Method | Endpoint                                    |
| ------ | ------------------------------------------- |
| GET    | /expenses                                   |
| GET    | /expenses/user/{userId}                     |
| GET    | /expenses/title/{title}                     |
| GET    | /expenses/category/{category}               |
| GET    | /expenses/amount/{amount}                   |
| GET    | /expenses/user/{userId}/category/{category} |
| POST   | /expense                                    |
| PUT    | /expenses/{id}                              |
| DELETE | /expenses/{id}                              |

## Security

Passwords are securely stored using BCrypt hashing instead of plain text storage.

Example:

Password:
123456

Stored in Database:
$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Future Improvements

* JWT Authentication
* Role Based Authorization
* Expense Dashboard Analytics
* Monthly Expense Reports
* CSV Export
* Pagination & Sorting

## Author

Rabin Mallick

GitHub: https://github.com/mallickrabin102-rgb
