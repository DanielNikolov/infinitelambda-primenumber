FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} primenumber.jar
ENTRYPOINT ["java", "-jar", "/primenumber.jar"]