# KeyValidator

KeyValidator is a microservice for validating license keys in the UGreen system. The project is built with Java using Spring Boot and leverages Docker for containerization.

## Technologies
- **Java** 17
- **Spring Boot** (Spring Web, Spring Data, Spring Security)
- **Maven** (for dependency management and project build)
- **PostgreSQL** (main database)
- **AWS RDS** (cloud database solution)
- **H2** (in-memory database for testing)
- **Flyway Migrations** (database version control)
- **Docker & Docker Compose** (for containerization)
- **GitHub Actions** (CI/CD)

## Installation & Running

### Using Docker
1. Clone the repository:
   ```sh
   git clone https://github.com/VitaliiChekalenko/KeyValidator.git
   cd KeyValidator
   ```
2. Start the service using Docker Compose:
   ```sh
   docker-compose up -d
   ```
3. The API will be available at `http://localhost:8080`.

### Running Locally
1. Install PostgreSQL and create a database `keyvalidator`.
2. Configure environment variables in `application.properties` or `.env`.
3. Run the migration scripts using Flyway.
4. Build and start the application:
   ```sh
   mvn clean install
   java -jar target/keyvalidator.jar
   ```

## API Usage

### Validate a License Key
#### Request
```http
POST /api/validate
Content-Type: application/json

{
  "licenseKey": "ABC-123-XYZ"
}
```
#### Response
```json
{
  "valid": true,
  "message": "License key is valid."
}
```

## CI/CD
The project uses GitHub Actions for automated testing and deployment. Any changes to the `main` branch trigger tests and update the Docker image.

## Contact
- **Author**: Vitalii Chekalenko
- **GitHub**: [VitaliiChekalenko](https://github.com/VitaliiChekalenko)

## License
This project is licensed under the MIT License.
