bus-client
-------------
### pom.xml
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-kafka</artifactId>
    </dependency>
### application.yml
    spring:
      application:
        name: config-server
      kafka:
        host: localhost
        port: 5672
        username: user
        password: secret

### operate
    start config-server bus-client bus-client-2
    http://localhost:8060/from
    show some msg
    
    update  application.properties of project atom-config
    post http://localhost:8060/bus/refresh
    
    visit http://localhost:8060/from
          http://localhost:8050/from
    response will change
    
    update single project cfg
    http://localhost:8060/bus/refresh?destination=bus-client:8060
    
  
## note:
    Spring Boot sets the ID for you in the ContextIdApplicationContextInitializer to a combination of the spring.application.name, active profiles and server.port by default.