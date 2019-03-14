FROM openjdk:8-jdk-slim

WORKDIR /selenium/test/caa

# Add all files to build app
ADD ./ /selenium/test/caa

# To install maven
RUN apt-get update \
    && apt-get install -y maven nano iputils-ping

# Build maven app
RUN mvn -DbuildDirectory=config.apptest.properties clean compile assembly:single

# Command line to execute the test
ENTRYPOINT ["java", "-jar", "/selenium/test/caa/target/Selenium_Zalenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]

# /usr/bin/java