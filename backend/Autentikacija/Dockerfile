FROM maven:3.8.1-openjdk-16 AS appBuild
WORKDIR /usr/src/Autentikacija
COPY . .
RUN ["mvn", "package", "-DskipTests"]
FROM openjdk:8-jdk-alpine AS appRuntime
WORKDIR /Autentikacija
COPY --from=appBuild /usr/src/Autentikacija/target/Autentikacija-0.0.1-SNAPSHOT.jar ./
EXPOSE 7878
CMD java -jar autentikacija-0.0.1-SNAPSHOT.jar