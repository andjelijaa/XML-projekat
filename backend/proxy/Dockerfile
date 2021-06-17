FROM maven:3.8.1-openjdk-16 AS appBuild
WORKDIR /usr/src/proxy
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM maven:3.8.1-openjdk-16 AS appBuild
WORKDIR /proxy
COPY --from=appBuild /usr/src/proxy/target/proxy-server-0.0.1-SNAPSHOT.jar ./
EXPOSE 2222
CMD java -jar proxy-server-0.0.1-SNAPSHOT.jar