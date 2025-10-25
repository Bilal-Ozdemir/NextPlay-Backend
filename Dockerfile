# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy all files to container
COPY . .

# Give Maven wrapper permission and build
RUN chmod +x mvnw
RUN ./mvnw -q -DskipTests package

# Expose port 8080
EXPOSE 8080

# Start the Spring Boot app
CMD ["java", "-jar", "/app/target/*.jar"]
