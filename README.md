# Bank Account REST Service

A simple RESTful API for managing bank accounts built with Spring Boot.

## Technologies Used

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- H2 Database (in-memory)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Running the Application

```bash
./mvnw spring-boot:run
```

The application will start on port 8000. You can access the H2 database console at [http://localhost:8000/h2-console](http://localhost:8000/h2-console).

## API Endpoints

| Method | URL                   | Description                     |
|--------|----------------------|---------------------------------|
| GET    | /api/comptes         | Get all accounts                |
| GET    | /api/comptes/{id}    | Get account by ID               |
| POST   | /api/comptes         | Create a new account            |
| PUT    | /api/comptes/{id}    | Update an existing account      |
| DELETE | /api/comptes/{id}    | Delete an account               |

## Sample Account JSON

```json
{
  "id": "C001",
  "proprietaire": "Ali Ben Mohamed",
  "solde": 5000.0,
  "type": "Courant"
}
```

## Database Configuration

The application uses an in-memory H2 database with the following configuration:
- URL: jdbc:h2:mem:bankdb
- Username: sa
- Password: password

## Sample Data

The application is initialized with sample accounts for testing purposes.
