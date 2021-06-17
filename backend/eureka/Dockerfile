FROM maven:3.8.1-openjdk-16 AS appBuild
ADD target/eureka-0.0.1-SNAPSHOT.jar eureka-0.0.1-SNAPSHOT.jar
EXPOSE 1111
ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]


