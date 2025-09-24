FROM maven:3.9.3-eclipse-temurin-17 As build
LABEL authors="stevetchoumi"
WORKDIR /app/
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar ./book.jar
EXPOSE 5051
CMD ["java", "-jar", "book.jar"]