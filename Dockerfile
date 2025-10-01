# Use Maven with OpenJDK 21 as base image
FROM maven:3.9.9-eclipse-temurin-21

# Set working directory inside container
WORKDIR /app

# Copy the entire main directory into the container
COPY main/ /app/

# Build the application and create Linux installer with jpackage
RUN mvn clean package

# Note: jpackage creates native installers in target/dist/
# The installer will be available to copy out after build completes