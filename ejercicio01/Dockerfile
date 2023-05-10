FROM openjdk:8-jdk-alpine
MAINTAINER rober
ARG JAR_FILE=target/ejercicio01-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]