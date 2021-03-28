FROM adoptopenjdk:11-jre
COPY target/TestBase-1.0-SNAPSHOT.jar /demo.jar
ENTRYPOINT ['java', '-jar','/demo.jar']
