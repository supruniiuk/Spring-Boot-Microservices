FROM openjdk:17-alpine

WORKDIR /opt/server
COPY ./target/service-feedback-0.0.1-SNAPSHOT.jar service-feedback.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "service-feedback.jar"]