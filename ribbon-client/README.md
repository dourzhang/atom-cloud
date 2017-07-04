ribbon-client
-------------
### pom.xml  
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-ribbon</artifactId>
    </dependency>
     
### Java   
    Application @RibbonClient(name = "ribbon-server", configuration = ClientConfiguration.class)
  
### ClientConfiguration
    injection bean
    
    IClientConfig
    IPing
    IRule

### cfg 
    ribbon-client.ribbon.eureka.enabled=false
    ribbon-client.ribbon.listOfServers=localhost:8090,localhost:8010
    ribbon-client.ribbon.ServerListRefreshInterval=15000

### ribbon with eureka 
    rm RibbonClient and ClientConfiguration
    rm cfg
    auto get server info from eureka
    
    ribbonServerList -> DiscoveryEnabledNIWSServerList
    IPing -> NIWSDiscoveryPing
    ServerList -> DomainExtractingServerList