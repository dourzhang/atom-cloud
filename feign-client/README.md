feign-client sample
==========================
    Feign是一种声明式、模板化的HTTP客户端。Dubbo RPC 
    封装了消费复杂 Restful 服务一系列的转换，编解码
    
Base Eureka    
### pom.xml  
    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-feign</artifactId>
   </dependency>
     
### Java   
    Application 
        @EnableEurekaServer
    
    RibbonServerClient
        @FeignClient(name = "ribbon-server", configuration = FeignClientConfiguration.class)
    代理 Restful 服务并自定义配置
    
    
### operate 
    start eureka-server ribbon-server
    visit http://serverip:8080/hi
    
    
### conf about debug log
    application.properties
    logging.level.com.spring.cloud.feign.UserFeignClient: DEBUG
    logging.level.com.watent.cloud.RibbonServerClient=DEBUG
     
    FeignClientConfiguration
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    
    note: default log levle none