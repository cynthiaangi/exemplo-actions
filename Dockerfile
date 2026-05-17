FROM maven:3.9.15-eclipse-temurin-21 as builder
LABEL authors="cynthia"

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /build/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
