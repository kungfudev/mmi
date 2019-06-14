FROM openjdk:12-ea-14-alpine3.8
COPY target/mmi-1.0-SNAPSHOT.jar /converter.jar
CMD ["usr/bin/java", "-Xrs -Xmx256m -jar", "converter.jar" ]