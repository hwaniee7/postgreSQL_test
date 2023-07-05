# Stage 1: Build Stage
FROM gradle:7-jdk-jammy@sha256:10c004cb27ecb756addd576a18f8b0aa9bd5895bde1a216519c25915a8f83d68 as build
WORKDIR /app
COPY build.gradle settings.gradle /app
RUN gradle --no-daemon dependencies
COPY . .
RUN gradle build --no-daemon


# Stage 2: Production Stage
FROM openjdk:17-ea-slim
WORKDIR /app
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
