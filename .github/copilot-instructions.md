# DSCommerce - AI Coding Guidelines

## Project Overview
This is a Spring Boot 3.5.10 e-commerce application using Java 21, built with Maven. The project follows standard Spring Boot conventions with JPA for data persistence and H2 database for development/testing.

## Architecture Patterns
- **Layered Architecture**: Implement controllers, services, repositories, and entities in separate packages under `com.devsuperior.dscomerce`
- **Entity Design**: Use JPA entities with proper relationships (e.g., `@OneToMany`, `@ManyToOne`) for e-commerce domain objects like Product, Category, Order, User
- **Service Layer**: Business logic in service classes with `@Service` annotation, handling transactions with `@Transactional`
- **REST Controllers**: Use `@RestController` with `@RequestMapping` for API endpoints, following RESTful conventions

## Development Workflow
- **Build**: Use `./mvnw clean install` for full build with tests
- **Run**: Execute `./mvnw spring-boot:run` to start the application on port 8080
- **Test**: Run `./mvnw test` for unit/integration tests using JUnit 5 and `@SpringBootTest`
- **Database**: H2 console available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## Code Conventions
- **Package Structure**: Follow `com.devsuperior.dscomerce.{entities, repositories, services, controllers, dto}`
- **Naming**: Use camelCase for methods/variables, PascalCase for classes
- **DTOs**: Create request/response DTOs in `dto` package to avoid exposing entities directly
- **Validation**: Use Bean Validation (`@Valid`, `@NotNull`, etc.) on DTOs and entities
- **Exception Handling**: Implement `@ControllerAdvice` for global exception handling

## Dependencies & Configuration
- **Database**: Configure JPA properties in `application.properties` for production databases (currently H2 for dev)
- **Profiles**: Use Spring profiles (`application-dev.properties`, `application-prod.properties`) for environment-specific configs
- **Security**: Integrate Spring Security for authentication/authorization when implementing user management

## Key Files
- `DscomerceApplication.java`: Main Spring Boot application class
- `pom.xml`: Maven dependencies (Spring Boot starters, H2, JUnit)
- `application.properties`: Basic configuration (application name)
- `HELP.md`: Spring Boot reference documentation links

## Testing Approach
- **Unit Tests**: Test services with mocked repositories using `@MockBean`
- **Integration Tests**: Use `@SpringBootTest` with test slices (`@DataJpaTest`, `@WebMvcTest`) for focused testing
- **Database Tests**: Leverage H2 for in-memory testing of JPA operations

## Deployment
- **JAR Build**: `./mvnw package` creates executable JAR in `target/`
- **OCI Image**: Use `./mvnw spring-boot:build-image` for containerized deployment