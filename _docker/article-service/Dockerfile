FROM openjdk:8-jdk-alpine
ADD article-service.jar article-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/article-service.jar"]
EXPOSE 8080