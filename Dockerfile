FROM openjdk:8u121-jdk

WORKDIR /usr/src/app

CMD ./gradlew bootRun