# SpringBoot-Woot
SpringBoot Backend API for an eCommerce application

# Getting Started

## Installation:
```shell
git clone https://github.com/HecticHiccups/SpringBoot-Woot.git
```
1. Import the project to your desired IDE my preference is IntelliJ
2. Once imported you must modify your `application.properties` file.

```shell
## Port
server.port = 3001

## Spring DATASOURCE
spring.datasource.url = jdbc:mysql://localhost/db_name
spring.datasource.username = root
spring.datasource.password = password

## Hibernate Properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.database-platform = org.hibernate.dialect.MySQL57Dialect
spring.jpa.show-sql = true

# Hibernate ddl auto=update will automatically create the tables
spring.jpa.hibernate.ddl-auto = update

```
3. Once modified you can run your server application.

Alternative: go to the project location in the terminal & run 
```shell
mvn spring-boot:run
```

## Endpoints:

### /api/users
returns json of all users within user entity model

```json
[
    {
        "userID": 2,
        "userEmail": "johnwick@gmail.com",
        "userName": "Witwicky",
        "firstName": "John",
        "lastName": "Wick",
        "password": "1234",
        "admin": true
    }
    ... 
]
```


### POST /api/user
insert new user into user entity, `userID` auto increments.

```json

    {
        "userEmail": "Anything",
        "userName": "Your",
        "firstName": "Heart",
        "lastName": "Desires",
        "password": "....",
        "admin": true
    }
    
```

### /api/user/:id
returns json of desired product determined by `id` params.

```json
[
    {
        "userID": 2,
        "userEmail": "johnwick@gmail.com",
        "userName": "Witwicky",
        "firstName": "John",
        "lastName": "Wick",
        "password": "1234",
        "admin": true
    }
]
```


### /api/product/:id
returns json of desired user determined by `id` params.

```json
[
   {
    "productID": 2,
    "productName": "One Piece Shirt",
    "productDescription": "A Sugoi Anime Shirt for Weebs",
    "productPrice": 12,
    "productQuantity": 12,
    "productImage": "onepiece.com"
  }
]
```

### /api/products
returns json of all products within product entity model

```json
[
    {
        "productID": 1,
        "productName": "Updated Naruto Shirt xx",
        "productDescription": "A Sugoi Anime Shirt for Weebs",
        "productPrice": 12,
        "productQuantity": 12,
        "productImage": "weirdurl.com"
    }
    ... 
]
```
## Built With:
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot
* [JPA](https://spring.io/projects/spring-data-jpa) - JPA
* [MySQL](https://www.mysql.com/) - MySQL

## Authors:
* **Jesus Arteaga**

## Acknowledgments:
* [Okta-React-SpringBoot](https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot) - Matt Raible
* [SpringBoot-CRUD](https://geekylearner.com/spring-boot-with-rest-api-example-using-spring-boot-with-jpa/) - Geeky Learner

