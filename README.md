Rick and Morty Finder API
Overview

The Rick and Morty Finder API is a RESTful web service that allows you to search for character appearances in the "Rick and Morty" TV series. It provides information about the episodes in which a character appears, including the name of the character and the date of their first appearance in the series.
Approach
Technologies Used

    Java
    Spring Boot
    Spring Web
    Spring Data
    OpenAPI (Swagger) for API documentation
    Docker for containerization

Directory Structure

The project is organized as follows:

    src/main/java: Contains the Java source code for the application.
    src/main/resources: Contains configuration files and static resources.
    src/test: Contains unit tests for the application.
    Dockerfile: Defines the Docker image for the application.
    openapi.yaml: OpenAPI specification for the API documentation.

API Endpoints

    GET /api/characters/search-character-appearance: Searches for character appearances by character name. Returns character appearance information.

How to Run
Prerequisites

    Java Development Kit (JDK) 17
    Docker (if running in a Docker container)


Running Locally
Clone the repository:
"git clone https://github.com/andresnf/rickandmortyfinder"
Go to the proyect folder:
"cd rick-and-morty-finder-api"

Build the project
execute in bash:
"./mvnw clean install"

Run the application
execute in bash:
"./mvnw spring-boot:run"

The API will be available at http://localhost:8080/.


Running with Docker

Build the Docker image.
execute in bash:
"docker pull amazoncorretto:17-alpine-jdk"
"docker build -t rick-and-morty-finder-api ."

Run the Docker container.
execute in bash:
"docker run -p 8080:8080 rick-and-morty-finder-api"

The API will be available at http://localhost:8080/.


How to Test

You can run unit tests for the application using the following command:
execute in bash:
"./mvnw test"


API Documentation

The API is documented using OpenAPI (Swagger). You can access the API documentation by visiting http://localhost:8080/swagger-ui.html when the application is running locally.
