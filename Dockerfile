FROM adoptopenjdk/openjdk11:latest

COPY target/TelesignMockServer*.jar third-party-mock-server.jar
COPY src/test/resources src/test/resources

EXPOSE 8096

CMD ["java", "-jar", "third-party-mock-server.jar"]
