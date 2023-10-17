# LILA project Backend

# Description

This is the backend part of the Lilaproject, a Java-based web application built using Spring Boot and Intellij IDEA. 
The project follows a Model-View-Controller (MVC) architecture pattern and provides RESTful APIs for managing data related to RidingHood, School, and Student entities. 
This README provides a brief overview of the project and its components.

## Tech Stack

Java

Spring Boot

Intellij IDEA

MySQL

Postman (for testing)


## Structure

The project is structured according to the Model-View-Controller (MVC) pattern:

#Models

This section defines the data structures used in the application. Including entities representing objects like:

RidingHood

School

Student

#Controllers

Controllers manage incoming HTTP requests and delegate the processing to the appropriate services. 

RidingHoodController

SchoolController

StudentController

#Repositories

Repositories provide an abstraction layer for database operations. You can find repository interfaces for entities such as:

JpaRidingHoodRepository

JpaSchoolRepository

JpaStudentRepository

#Services

Services contain the logic of the application. They perform operations, validations, and computations related to the application's core functionality. 

RidingHoodServices

SchoolServices

StudentServices

#application.properties: 

Contains configuration settings for the Spring Boot application, including the database connection.

#MySQL

The project uses MySQL as the database. You can configure the database connection in the application.properties file

## Usage

To run the project, make sure you have Java, Spring Boot, and MySQL installed. You can import the project into Intellij IDEA or your preferred IDE. After configuring the database connection, you can start the Spring Boot application.

You can use tools like Postman to test the RESTful APIs provided by the controllers. The endpoints are defined in the controller classes (RidingHoodController, SchoolController, StudentController).



## Summary of Test Creation for Student, School, and RidingHood:

Environment Setup:
Mockito and JUnit libraries were used for unit testing.
Annotations such as @InjectMocks and @Mock were configured to initialize mocked controllers and services.

Test Creation:
For each model, unit tests were created to validate the functionality of the methods within these models.
Tests were conducted on corresponding services to ensure that the Create, Read, Update, and Delete operations function correctly.

Controllers:
The controllers underwent testing to verify that the routes and HTTP request methods return the expected responses.

Result:
All tests were successfully executed, demonstrating that the models, services, and controllers for Student, School, and RidingHood function as expected.

These tests ensure that each component of the application (models, services, and controllers) operates consistently and meets the defined requirements before implementation in a production environment, enhancing the software's quality and reliability.
## Deployment

Follow these steps to deploy and run the application in your local environment.

#Prerequisites

Java Development Kit (JDK) 8 or higher installed.

Intellij IDEA or another Java development tool.

MySQL Server installed and running.

Postman or a similar tool for testing the APIs.

#Implementation Steps

Clone the Repository:

Clone this GitHub repository to your local machine using the following command:


git clone https://github.com/lila-project-games/lila-backend.git


#Import the Project in Intellij IDEA:

Open Intellij IDEA and select "File" > "Open" to open the cloned project.

Configure the Database:

Ensure your MySQL server is up and running.

In the application.properties file, adjust the database configuration, including the URL, username, and password, as needed.

Run the Application:

Execute the main class LilaProjectApplication by right-clicking on it and selecting "Run."
The Spring Boot application will start and be available at http://localhost:8080.

Test the APIs with Postman:

You can test the APIs using Postman or any similar tool. Here are examples of available endpoints:

POST /api/ridinghoods: Create a new instance of RidingHood.

GET /api/ridinghoods/{id}: Get an instance of RidingHood by its ID.

GET /api/ridinghoods: Get all instances of RidingHood.

PUT /api/ridinghoods: Update an instance of RidingHood.

DELETE /api/ridinghoods/{id}: Delete an instance of RidingHood by its ID.

You're all set! The Spring Boot application based on the project will be up and running in your local environment, and you can start developing and testing your custom functionalities.
