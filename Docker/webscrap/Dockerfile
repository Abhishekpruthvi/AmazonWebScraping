FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} webscrap.jar
ENTRYPOINT ["java","-jar","/webscrap.jar"]