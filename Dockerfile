FROM adoptopenjdk:11-jdk-openj9
ARG JAR_FILE=target/*.jar
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]