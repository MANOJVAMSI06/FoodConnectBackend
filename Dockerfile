# Use Gradle image to build the project
FROM gradle:8.4.0-jdk17 AS build

# Copy everything to /app
COPY --chown=gradle:gradle . /app

WORKDIR /app

# Build the Spring Boot app
RUN gradle build --no-daemon

# Use OpenJDK for running the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the generated jar from the build image
COPY --from=build /app/build/libs/*.jar app.jar

# Run the jar
CMD ["java", "-jar", "app.jar"]
