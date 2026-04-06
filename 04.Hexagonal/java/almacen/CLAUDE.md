# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 4.0.5 application named "almacen" (Spanish for "warehouse") built with:
- Java 21
- Gradle Kotlin DSL (build.gradle.kts)
- PostgreSQL database (runtime dependency)

## Build and Development Commands

### Build and Run
- **Build the project**: `./gradlew build`
- **Run the application**: `./gradlew bootRun`
- **Run tests**: `./gradlew test`
- **Run a specific test class**: `./gradlew test --tests "ucb.almacen.AlmacenApplicationTests"`
- **Clean build**: `./gradlew clean build`

### Development Utilities
- **Check dependencies**: `./gradlew dependencies`
- **Generate IDE project files**: `./gradlew idea` or `./gradlew eclipse`

## Project Structure

- **Main application**: `src/main/java/ucb/almacen/AlmacenApplication.java` - Spring Boot entry point
- **Configuration**: `src/main/resources/application.yaml` - Spring configuration (currently minimal)
- **Tests**: `src/test/java/ucb/almacen/AlmacenApplicationTests.java` - Basic Spring context test

## Dependencies

Key dependencies in `build.gradle.kts`:
- `spring-boot-starter` - Core Spring Boot starter
- `postgresql` - PostgreSQL JDBC driver (runtime only)
- `spring-boot-starter-test` - Testing utilities

## Architecture Notes

1. **Spring Boot 4.0.5**: Uses the latest Spring Boot version at time of project creation
2. **Minimal configuration**: Currently only has basic application name configuration
3. **PostgreSQL ready**: Database driver included but no data source configuration yet
4. **Standard Spring Boot structure**: Follows conventional Spring Boot project layout

## Development Notes

- The project uses Gradle wrapper (`gradlew`) for consistent builds
- Java 21 toolchain is configured in build.gradle.kts
- Test framework is JUnit 5 with Spring Boot test support
- No database configuration or entity classes exist yet - likely an early-stage project