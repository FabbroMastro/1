FROM openjdk:12
VOLUME /tmp
EXPOSE 8001
ADD ./target/prestamo-0.0.1-SNAPSHOT.jar prestamo.jar
ENTRYPOINT ["java","-jar","/prestamo.jar"]
