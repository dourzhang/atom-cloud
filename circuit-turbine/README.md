circuit-turbine 熔断监控
-------------
Base Eureka

### pom.xml  
    <!-- dashboard -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-actuator</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-eureka</artifactId>
            </dependency>
            <!-- turbine -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-turbine</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-netflix-turbine</artifactId>
            </dependency>
     
### application.properties
    #turbine
    # eureka 服务ID列表
    turbine.appConfig=circuit-client
    #指定聚合哪些集群
    turbine.aggregator.clusterConfig=default
    #SPEL表达式定义集群名
    turbine.clusterNameExpression= new String("default")
  
### Java 
    Application 
                @EnableTurbine
                @EnableHystrixDashboard
    
### operate               
    访问本服务端口 localhost:8080 
            监控  localhost:8080/turbine.stream
    访问熔断url 查看监控数据
    