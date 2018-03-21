FROM openjdk:8-jdk-alpine
ADD eureka-service.jar eureka-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-service.jar"]
EXPOSE 8761