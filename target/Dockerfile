FROM openjdk:12
VOLUME /tmp
EXPOSE 8003
ADD ./target/target-0.0.1-SNAPSHOT.jar target.jar
ENTRYPOINT ["java","-jar","/target.jar"]