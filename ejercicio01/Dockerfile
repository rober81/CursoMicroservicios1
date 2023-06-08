FROM openjdk:8-jdk-alpine

COPY opentelemetry-javaagent.jar /home/
ARG JAR_FILE=target/ejercicio01-0.0.1-SNAPSHOT.jar
ENV JAVA_TOOL_OPTIONS "-javaagent:/home/opentelemetry-javaagent.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]