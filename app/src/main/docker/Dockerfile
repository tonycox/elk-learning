FROM openjdk:8-alpine
RUN apk update && apk add ca-certificates wget && update-ca-certificates
MAINTAINER Anton Solovev "tonycoxbk@gmail.com"
COPY build/app-1.0-SNAPSHOT.jar app-1.0-SNAPSHOT.jar
CMD java -jar app-1.0-SNAPSHOT.jar
EXPOSE 8080
