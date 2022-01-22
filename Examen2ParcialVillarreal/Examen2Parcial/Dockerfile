FROM openjdk:11.0.13-jdk-oracle
VOLUME /tmp
ADD /Registro-Civil-Service/target/RegistroCivil-1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
