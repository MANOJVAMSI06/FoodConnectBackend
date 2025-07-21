# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from local to container
COPY build/libs/FoodConnectBackend-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
