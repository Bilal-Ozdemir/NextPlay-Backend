# ---- Build Stage ----
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app

# Copy Maven wrapper & pom.xml first for dependency caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copy source and build the project
COPY src src
RUN ./mvnw -q -DskipTests package

# ---- Run Stage ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/games-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
