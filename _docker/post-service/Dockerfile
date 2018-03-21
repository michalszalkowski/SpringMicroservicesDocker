FROM openjdk:8-jdk-alpine
ADD post-service.jar post-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/post-service.jar"]

#HEALTHCHECK --interval=5s --timeout=2s --retries=12 \
#  CMD curl --silent --fail post-service/actuator/health || exit 1

EXPOSE 8080