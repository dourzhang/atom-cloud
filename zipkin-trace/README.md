zipkin-trace  分布式追踪
==========================
zipkin-trace sample

### pom.xml
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-server</artifactId>
    </dependency>
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-autoconfigure-ui</artifactId>
    </dependency>

### java
    Application 
       @EnableZipkinServer

operate 
    start zipkin-trace zipkin-server  zipkin-client
    visit http://zipkin-client/hello
    check http://zipkin-trace 