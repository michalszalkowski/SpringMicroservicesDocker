FROM openjdk:8-jdk-alpine
ADD config-service.jar config-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-service.jar"]
EXPOSE 8888