# Build stage
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY Main.java .
RUN javac Main.java

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copy the compiled class
COPY --from=builder /app/Main*.class ./
# Copy the static assets
COPY index.html ./

EXPOSE 8080

CMD ["java", "Main"]
