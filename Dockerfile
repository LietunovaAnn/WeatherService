FROM openjdk:11
ADD target/weatherApp.war weatherApp.war
EXPOSE 8787
CMD ["java", "-jar", "weatherApp.war"]