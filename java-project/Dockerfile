# Build stage
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY Main.java .
RUN javac Main.java

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/Main*.class ./
EXPOSE 8080
CMD ["java", "Main"]
