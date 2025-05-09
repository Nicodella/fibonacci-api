# Proyecto Spring Boot con Maven
Se recomienda abrir proyecto desde visual code
Este proyecto ha sido creado utilizando **Spring Boot** y **Maven**.

---

## Base de Datos: MySQL

Se utiliza **MySQL** como sistema de gestión de base de datos. Para la administración y visualización se recomienda usar **DBeaver**.

### Configuración de la Base de Datos

Crear una conexión en DBeaver (o en tu IDE favorito) con los siguientes datos:

- **Database:** `springbootdb`
- **Servidor:** `localhost`
- **Puerto:** `3306`
- **Usuario y contraseña:** los que hayas definido al instalar MySQL

### Configuración `application.properties`

spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
spring.datasource.username=springuser
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

server.error.whitelabel.enabled=false


Para correr el proyecto
mvn clean install

mvn spring-boot:run

Una vez que el servidor esté corriendo, puedes ver y probar los endpoints a través de Swagger en:
http://localhost:8080/swagger-ui/index.html#/

El cubrimiento de codigo se podra visualizar desde fibonacci-api/target/site/jacoco/index.html