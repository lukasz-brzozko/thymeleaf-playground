# Etap 1: Budowanie aplikacji
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Kopiowanie plików konfiguracyjnych i pobranie zależności
COPY pom.xml .
RUN mvn dependency:go-offline

# Kopiowanie kodu źródłowego i budowanie aplikacji
COPY src ./src
RUN mvn clean package -DskipTests

# Etap 2: Uruchamianie aplikacji
FROM eclipse-temurin:17-jre
WORKDIR /app

# Kopiowanie zbudowanego pliku JAR
COPY --from=builder /app/target/*.jar app.jar

# Eksponowanie portu 8080
EXPOSE 8080

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "app.jar"]
