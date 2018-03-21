FROM openjdk:8-jdk-alpine
ADD gateway-service.jar gateway-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service.jar"]
EXPOSE 8080