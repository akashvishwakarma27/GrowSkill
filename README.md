# GrowSkill Project

## Overview

The GrowSkill project is a platform for online courses where users can enroll in various courses, instructors can create and manage courses, and payments can be processed for course enrollments.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Jackson
- Maven

## Project Structure

The project is structured into several packages:

- `com.GrowSkil.controller`: Contains controllers for handling HTTP requests.
- `com.GrowSkil.entity`: Contains entity classes representing database tables.
- `com.GrowSkil.exception`: Contains custom exception classes.
- `com.GrowSkil.repository`: Contains repositories for database operations.
- `com.GrowSkil.service`: Contains service interfaces and implementations.

## Setup Instructions

1. Clone the repository to your local machine.
2. Make sure you have JDK and Maven installed.
3. Create a MySQL database and update the database configuration in `application.properties`.
4. Run `mvn clean install` to build the project.
5. Run the Spring Boot application using `mvn spring-boot:run` or by running the main class `GrowSkillApplication`.

## Endpoints

- `/courses`: CRUD operations for courses.
- `/enrollments`: Endpoint for enrolling users in courses.
- `/instructors`: CRUD operations for instructors.
- `/payments`: Endpoint for processing payments.
- `/classes`: Endpoint for managing training classes.
- `/users`: CRUD operations for users.

## Usage

1. Use the provided services to manage courses, enrollments, payments, instructors, classes, and users.
