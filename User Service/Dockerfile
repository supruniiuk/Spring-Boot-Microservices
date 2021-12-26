FROM openjdk:17-alpine

WORKDIR /opt/server
COPY ./target/service-user-0.0.1-SNAPSHOT.jar service-user.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "service-user.jar"]