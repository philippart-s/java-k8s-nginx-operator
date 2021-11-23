# Do not use, use jib instead
FROM adoptopenjdk:11-jre

ENTRYPOINT ["java", "-jar", "/usr/share/operator/operator.jar"]

ARG JAR_FILE
ADD target/java-k8s-nginx-operator-1.0.0-SNAPSHOT-jar-with-dependencies.jar /usr/share/operator/operator.jar
