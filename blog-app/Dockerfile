# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Publish the artifact
FROM alpine:3.18 AS publish
WORKDIR /publish
COPY --from=build /app/target/*.jar app.jar
RUN echo "Publishing artifact: app.jar"

# Stage 3: Create the runtime image
FROM openjdk:17-jdk-slim AS runtime
WORKDIR /app
COPY --from=publish /publish/app.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]