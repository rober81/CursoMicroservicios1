FROM openjdk:19-jdk-alpine

RUN curl -o opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.27.0/opentelemetry-javaagent.jar
COPY opentelemetry-javaagent.jar /home/
ENV JAVA_TOOL_OPTIONS "-javaagent:/home/opentelemetry-javaagent.jar"
ARG JAR_FILE=target/api-transferencias-curso-ms-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]