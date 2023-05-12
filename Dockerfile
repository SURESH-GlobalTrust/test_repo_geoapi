FROM eclipse-temurin:17-jre-alpine

# Set the working directory to /GeoAPI
WORKDIR /GeoAPI

# Copy the war file from target folder
COPY $(Build.SourcesDirectory)/War-Files/gtgeodata-0.0.1.war /GeoAPI/

# port 8080 is available to the world outside this container
EXPOSE 8090

# environment variable for Spring
#ENV SPRING_PROFILES_ACTIVE=Dev

# maintainer information
LABEL maintainer="Suresh Andem <suresh.andem@globaltrustgrp.com>"

# Run the application when the container launches
ENTRYPOINT ["java", "-jar", "gtgeodata-0.0.1.war"]

