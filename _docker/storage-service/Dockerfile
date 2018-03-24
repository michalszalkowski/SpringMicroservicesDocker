FROM openjdk:8-jdk-alpine
ADD storage-service.jar storage-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/storage-service.jar"]

EXPOSE 8080