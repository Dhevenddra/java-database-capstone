# Stage 1: Build the application using Maven and JDK 17
# This stage uses a slim Maven image to minimize overhead.
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Build the application JAR while skipping unit tests for speed during this stage
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime environment
# This stage uses a smaller OpenJDK image to run the compiled JAR.
FROM openjdk:17-jdk-slim

# Set the working directory for the application
WORKDIR /app

# Copy the compiled application JAR from the build stage to this stage
COPY --from=build /app/target/smartcare-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port (8080) for external access
EXPOSE 8080

# Configure the entrypoint to run the JAR using the Java runtime
ENTRYPOINT ["java","-jar","app.jar"]
