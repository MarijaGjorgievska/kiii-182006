FROM openjdk:17
LABEL authors="Marija"
EXPOSE 8080
ARG JAR_FILE=target/kiii-182006-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]