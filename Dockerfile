FROM openjdk:11.0.6
WORKDIR /usr/src/course-service
COPY target/course-service-0.0.1-SNAPSHOT.jar .
EXPOSE 4060
ENTRYPOINT ["java", "-jar", "course-service-0.0.1-SNAPSHOT.jar"]