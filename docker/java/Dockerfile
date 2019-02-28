FROM openjdk:8-jre
MAINTAINER Richie Rees <rjrees@hotmail.com>
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar", "server", "./config.yaml"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar
