FROM maven:3.8.1-openjdk-16 AS appBuild
WORKDIR /usr/src/Profilmicroservis
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:16-jdk AS appRuntime
WORKDIR /Profilmicroservis
COPY --from=appBuild /usr/src/Profilmicroservis/target/Profilmicroservis-0.0.1-SNAPSHOT.jar ./
EXPOSE 7877
CMD java -jar Profilmicroservis-0.0.1-SNAPSHOT.jar