zuul-gateway
-------------
### pom.xml  
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zuul</artifactId>
      </dependency>
     
### Java   
    Application @EnableZuulProxy
  
### Filter
    filterType()
    filterOrder()
    shouldFilter()
    run()

### cfg 

    The request of proxy 
    zuul.routes.zuul-client.url=http://localhost:8080
    ribbon.eureka.enabled=false

operate:
    start zuul-client zuul-gateway
    http://localhost:8000/zuul-client/available
    zuul-gateway log 
    