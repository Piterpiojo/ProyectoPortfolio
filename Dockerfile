FROM render-examples/render-java-11:latest
MAINTAINER Aldo
COPY target/Portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
CMD java -Dserver.port=$PORT -jar /portfolio.jar
