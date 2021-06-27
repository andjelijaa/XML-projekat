FROM maven:3.8.1-openjdk-16 AS appBuild7
WORKDIR /usr/src/Objavemicroservis
COPY . .
RUN ["mvn", "package", "-DskipTests"]
FROM openjdk:16-jdk AS appRuntime2
WORKDIR /Objavemicroservis
COPY --from=appBuild7 /usr/src/Objavemicroservis/target/Objavemicroservis-0.0.1-SNAPSHOT.jar ./
EXPOSE 7876
CMD java -jar Objavemicroservis-0.0.1-SNAPSHOT.jar