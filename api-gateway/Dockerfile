FROM openjdk:17-alpine

WORKDIR /opt/server
COPY ./target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]