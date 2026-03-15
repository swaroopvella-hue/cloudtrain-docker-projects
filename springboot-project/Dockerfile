# Stage 1: Build the massive fat JAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy the pom.xml and resolve dependencies separately to cache them
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the actual source code and build it
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create a slim runtime container using only the JRE
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy only the compiled fat JAR from the builder stage
# Naming it app.jar for simplicity
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
