FROM amazoncorretto:11-alpine-jdk
MAINTAINER Aldo
COPY target/Portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
CMD java -Dserver.port=$PORT -jar /portfolio.jar
