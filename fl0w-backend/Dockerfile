# Dockerfile for building and running the Fl0w backend application


# Use a multi-stage build to keep the final image small, skipping tests during build
FROM eclipse-temurin:17-jdk as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests


# Start new image with only the built JAR file (only the necessary runtime dependencies)
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/fl0w-backend-*.jar /app/fl0w-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fl0w-backend.jar"]