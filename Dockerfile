FROM maven:3.8.4-openjdk-17-slim AS builder

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-slim

COPY --from=builder target/SpringBootCRUD-0.0.1-SNAPSHOT.war /app.war

CMD ["java","-jar","/app.war"]
