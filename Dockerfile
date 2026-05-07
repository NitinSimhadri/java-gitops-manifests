FROM eclipse-temurin:17

WORKDIR /app

COPY target/java-devops-app-1.0.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
