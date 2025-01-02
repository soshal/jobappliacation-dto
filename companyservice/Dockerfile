# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the actual JAR file into the container
COPY target/companyservice-0.0.1-SNAPSHOT.jar /app/companyservice.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/companyservice.jar"]

