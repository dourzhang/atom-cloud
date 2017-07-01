config-client 
-------------
### pom.xml  
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-client</artifactId>
    </dependency>  
     
### bootstrap.properties
    spring.cloud.config.uri=http://configServerUri
  
### 匹配格式
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties