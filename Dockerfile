# Use an official OpenJDK runtime as a parent image
FROM FROM openjdk:17-jdk-slim 

# Set the working directory in the container
WORKDIR /app

# Copy the local project files to the container's working directory
COPY . .

# Build the application
RUN ./mvnw package

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/your-springboot-app.jar"]
