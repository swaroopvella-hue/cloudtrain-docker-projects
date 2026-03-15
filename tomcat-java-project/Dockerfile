# Stage 1: Build the WAR file using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application. This will generate ROOT.war in the target directory
RUN mvn clean package

# Stage 2: Deploy to Tomcat
FROM tomcat:10.1-jdk17
# Remove the default Tomcat webapps to keep it clean
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the generated WAR file directly to the webapps directory as ROOT.war
# This makes exploring it accessible at http://localhost:8080/
COPY --from=builder /app/target/ROOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
