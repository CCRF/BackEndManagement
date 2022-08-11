FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/backendmanagement.jar backendmanagement.jar
ENTRYPOINT ["java","-jar","/backendmanagement.jar", "&"]