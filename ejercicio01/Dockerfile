FROM openjdk:8-jdk-alpine

RUN wget https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.27.0/opentelemetry-javaagent.jar -P /home
ARG JAR_FILE=target/ejercicio01-0.0.1-SNAPSHOT.jar
ENV JAVA_TOOL_OPTIONS "-javaagent:/home/opentelemetry-javaagent.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]