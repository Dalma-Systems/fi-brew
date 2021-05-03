FROM openjdk:11-jdk-slim

RUN apt-get update && apt-get -y install curl && apt-get clean

ADD fibrew-api-web/target/dalma-fibrew-api.jar /app/

EXPOSE 8080

ENTRYPOINT ["java","-jar", "/app/dalma-fibrew-api.jar"]
