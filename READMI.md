Proyecto creado con maven

BASE DE DATOS
MYSQL
Para la gestion de la base y la visualizacion use dbeaver

Configuracion de la base

Crear una conection con los siguientes datos
Database: springbootdb
ServerHost: localhost
Puerto: 3306
Nombre de usuario y Pass las que se hayan configurado en el sistema cuando se instala mysql

spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
spring.datasource.username=springuser
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
server.error.whitelabel.enabled=false
spring.jpa.defer-datasource-initialization=true

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.sql.init.mode=always


Abrir proyecto desde visual code

Para correr el proyecto
mvn clean install

mvn spring-boot:run

Para la vista de los endpoint se puede ver desde swagger
http://localhost:8080/swagger-ui/index.html#/