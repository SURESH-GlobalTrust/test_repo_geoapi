FROM eclipse-temurin:17-jre-alpine

# Set the working directory to /GeoAPI
WORKDIR /GeoAPI

# Copy the war file from target folder
COPY target/gtgeodata-0.0.1.war /GeoAPI/geodata.war

# port 8080 is available to the world outside this container
EXPOSE 8080

# environment variable for Spring
#ENV SPRING_PROFILES_ACTIVE=Dev

# maintainer information
LABEL maintainer="Suresh Andem <suresh.andem@globaltrustgrp.com>"

# Run the application when the container launches
ENTRYPOINT ["java", "-jar", "geodata.war"]

