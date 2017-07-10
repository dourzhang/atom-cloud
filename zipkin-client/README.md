zipkin-client 
==========================
zipkin-trace sample

### pom.xml
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zipkin</artifactId>
     </dependency>

### conf
    application
       spring.zipkin.base-url=http://zipkin-server:port

zipkin Stream
-------------

### pom.xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-stream</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-stream-binder-kafka</artifactId>
    </dependency>

### conf
    spring:
      cloud:
        stream:
          kafka:
            binder:
              brokers: localhost:9092
              zkNodes: localhost:2181