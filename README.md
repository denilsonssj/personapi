<h1 align="center">Person API</h1>

## Getting started

### Installation

Clone the repository
``` 
$ git clone https://github.com/denilsonssj/personapi
```

### Prerequisites

First, make sure you use JDK version 11 or higher. You can download this version at this [link](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html).

After, create file application.properties in location *src/main/resources/* and copy with the values below and replace him.

```yml
spring.datasource.url: jdbc:postgresql://127.0.0.1:5432/personapi
spring.datasource.username: postgres
spring.datasource.password: postgres
spring.jpa.database-platform: org.hibernate.dialect.PostgreSQL94Dialect
spring.jpa.show-sql: false
spring.jpa.hibernate.ddl-auto: update
server.port: 9000
```

### Installing dependencies

Now, install all dependencies using maven: 
``` 
$ ./mvnw install -U clean
```
### Running the application

```
$ ./mvnw spring-boot:run
``` 

## Technologies and tools

- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [JDK11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Lombok](https://projectlombok.org/)
- [Swagger](https://swagger.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Junit 5](https://junit.org/junit5/)

## Testing the application
...

## Demo

The demo project can be viewed [here](https://denilsonssj-personapi.herokuapp.com/swagger-ui/).

## License

[MIT](https://github.com/denilsonssj/algalog/blob/main/LICENSE)