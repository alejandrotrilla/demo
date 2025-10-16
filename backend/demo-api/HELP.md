# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.6/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.6/maven-plugin/build-image.html)
* [Cloud Bootstrap](https://docs.spring.io/spring-cloud-commons/reference/spring-cloud-commons/application-context-services.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.5.6/reference/actuator/index.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.6/reference/using/devtools.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.5.6/reference/data/nosql.html#data.nosql.mongodb)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/3.5.6/reference/messaging/amqp.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.5.6/specification/configuration-metadata/annotation-processor.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.6/reference/web/servlet.html)
* [OAuth2 Client](https://docs.spring.io/spring-boot/3.5.6/reference/web/spring-security.html#web.security.oauth2.client)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/3.5.6/reference/web/spring-security.html#web.security.oauth2.authorization-server)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/3.5.6/reference/web/spring-security.html#web.security.oauth2.server)
* [Docker Compose Support](https://docs.spring.io/spring-boot/3.5.6/reference/features/dev-services.html#features.dev-services.docker-compose)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mongodb: [`mongo:latest`](https://hub.docker.com/_/mongo)
* rabbitmq: [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)

Please review the tags of the used images and set them to the same as you're running in production.

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

