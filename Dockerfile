FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
