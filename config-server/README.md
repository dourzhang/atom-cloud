config-server 
-------------
### pom.xml  
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
     </dependency>   
     
### bootstrap.properties
    spring.cloud.config.server.git.uri=https://configUri
  
### Java   
    Application @EnableConfigServer
  
### url
    /env