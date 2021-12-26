FROM openjdk:17-alpine

WORKDIR /opt/server
COPY ./target/service-vacancy-0.0.1-SNAPSHOT.jar service-vacancy.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "service-vacancy.jar"]