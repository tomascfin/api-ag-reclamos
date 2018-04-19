FROM openjdk:9
ADD target/gestion-reclamos.jar gestion-reclamos.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "gestion-reclamos.jar"]
