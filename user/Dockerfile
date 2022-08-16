FROM openjdk:12
VOLUME /tmp
EXPOSE 8002
ADD ./target/user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","/user.jar"]
