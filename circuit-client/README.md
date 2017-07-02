circuit-client
-------------
Base Eureka

### pom.xml  
    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-hystrix</artifactId>
    </dependency> 
     
### bootstrap.properties
    spring.cloud.config.uri=http://configServerUri
  
### Java 
    Application 
                @EnableDiscoveryClient
                @EnableHystrixDashboard
                @EnableCircuitBreaker