FROM maven:3.9.3-eclipse-temurin-17
LABEL authors="stevetchoumi"
WORKDIR /app/
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


ENTRYPOINT ["java", "-jar", "target"]