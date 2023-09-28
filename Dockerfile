FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY target/rickandmortyfinder-0.0.1-SNAPSHOT.jar rickandmortyfinder.jar
EXPOSE 8080
CMD ["java", "-jar", "rickandmortyfinder.jar"]