# Etapa 1: Build com Maven
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Gera o JAR (sem rodar os testes para agilizar)
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com JDK 8
FROM openjdk:8-jdk-alpine

# Cria o usuário spring
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copia o JAR da etapa de build
COPY --from=build /app/target/*.jar /app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
