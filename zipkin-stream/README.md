zipkin-stream sample
==========================
zipkin with stream

### pom.xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter</artifactId>
     </dependency>
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-sleuth</artifactId>
     </dependency>
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-zipkin</artifactId>
     </dependency>
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-stream-binder-kafka</artifactId>
     </dependency>
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
     </dependency>
     <dependency>
         <groupId>io.zipkin.java</groupId>
         <artifactId>zipkin-autoconfigure-ui</artifactId>
     </dependency>
     
     
### conf 
    note: stream kafka config and trance db store
    spring:
      cloud:
        stream:
          kafka:
            binder:
              brokers: localhost:9092
              zkNodes: localhost:2181
        ---
    spring:
      application:
        name: zipkin-stream
      datasource:
        schema: classpath:/mysql.sql
        url: jdbc:mysql://localhost:9406/zipkin-stream?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull
        driverClassName: com.mysql.jdbc.Driver
        username: root
        password: 123456
        # Switch this on to create the schema on startup:
        initialize: true
        continueOnError: true
      sleuth:
        enabled: false
    
    # default is mem (in-memory)
    zipkin:
      storage:
        type: mysql

              
### Java
    Application
        @EnableZipkinStreamServer
        @SpringBootApplication
        @MessageEndpoint
    
### op
    start zipkin-server zipkin-client zipkin-stream
    visit client url
    see zipkin-stream
