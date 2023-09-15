FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/sbb-0.0.5.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8020
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]