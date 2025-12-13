FROM eclipse-temurin:21-jdk
ARG JAR_FILE=build/libs/springcicddemo1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java"]
CMD ["-jar","app.jar"]