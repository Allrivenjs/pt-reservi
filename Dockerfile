# Usa una imagen base de OpenJDK 21 para la construcción
FROM openjdk:21-jdk-slim AS builder

# Instala Maven en la imagen
RUN apt-get update && apt-get install -y maven

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y las dependencias del proyecto
COPY pom.xml .
COPY src ./src

# Ejecuta Maven para compilar el proyecto y generar el archivo JAR
RUN mvn clean package -DskipTests

# Usa una imagen de OpenJDK 21 para ejecutar la aplicación
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto 8080 para que se pueda acceder a la aplicación
EXPOSE 8080

# Comando para ejecutar el archivo JAR de Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
