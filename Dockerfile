FROM openjdk:11
ADD target/clientui-0.0.1.SNAPSHOT.jar clientUi-microservice-docker.jar
ENTRYPOINT ["java", "-jar", "clientUi-microservice-docker.jar"]