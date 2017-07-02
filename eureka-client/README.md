config-server 
-------------
### pom.xml  
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
     
### application.properties
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
  
### Java   
    Application @EnableDiscoveryClient
  
