FROM maven:3.8.1-ibmjava-8-alpine AS appBuild
WORKDIR /usr/src/Profilmicroservis
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:8-jdk-alpine AS appRuntime
WORKDIR /Profilmicroservis
COPY --from=appBuild /usr/src/Profilmicroservis/target/Profilmicroservis-0.0.1-SNAPSHOT.jar ./
EXPOSE 7877
CMD java -jar Profilmicroservis-0.0.1-SNAPSHOT.jar