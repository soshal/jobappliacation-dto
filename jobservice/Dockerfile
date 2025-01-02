# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your local machine into the container
COPY target/jobservice.jar /app/jobservice.jar

# Expose the port on which the service will run
EXPOSE 8081

# Run the application (Spring Boot)
CMD ["java", "-jar", "/app/jobservice.jar"]
