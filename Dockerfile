FROM amazoncorretto:11-alpine-jdk
maintainer Aldo
copy target/Portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
entrypoint ["java","-jar","/portfolio.jar"]
