# Employee JDBC App (PostgreSQL)

A simple Java console application to perform **CRUD operations** (Create, Read, Update, Delete) on an Employee database using **raw JDBC** with **PostgreSQL**.

This project is part of internship Task 7: *Java JDBC – Employee Database App*.

---

## Features
- Connects to PostgreSQL using JDBC.
- Add a new employee.
- View all employees.
- View employee by ID.
- Update employee details.
- Delete employee.
- Uses **PreparedStatement** to prevent SQL Injection.
- Uses **try-with-resources** to manage JDBC resources.

---

## Technologies Used
- Java (JDK 11 or higher)
- JDBC
- PostgreSQL
- Maven

---

## Database Setup (PostgreSQL)

Run the following commands in PostgreSQL (psql or pgAdmin):

```sql
CREATE DATABASE employee_db;

\c employee_db;

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary NUMERIC(10,2)
);
