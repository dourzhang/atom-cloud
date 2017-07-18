eureka-server
-------------
### pom.xml  
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka-server</artifactId>
    </dependency>
     
### Java   
    Application @EnableEurekaServer
    
    
### note:

    Eureka server和client之间每隔30秒会进行一次心跳通信，告诉server，client还活着。由此引出两个名词： 
    Renews threshold：server期望在每分钟中收到的心跳次数 
    Renews (last min)：上一分钟内收到的心跳次数。
    
    禁止注册server自己为client，不管server是否禁止，阈值（threshold）是1。client个数为n，阈值为1+2*n（此为一个server且禁止自注册的情况） 
    如果是多个server，且开启了自注册，那么就和client一样，是对于其他的server来说就是client，是要*2的
    
    Eurake有一个配置参数eureka.server.renewalPercentThreshold，定义了renews 和renews threshold的比值，默认值为0.85。当server在15分钟内，
    比值低于percent，即少了15%的微服务心跳，server会进入自我保护状态，Self-Preservation。在此状态下，server不会删除注册信息，这就有可能导致在
    调用微服务时，实际上服务并不存在。 
    这种保护状态实际上是考虑了client和server之间的心跳是因为网络问题，而非服务本身问题，不能简单的删除注册信息
    
    stackoverflow上，有人给出的建议是： 
    1、在生产上可以开自注册，部署两个server 
    2、在本机器上测试的时候，可以把比值调低，比如0.49D
    3、或者简单粗暴把自我保护模式关闭
    
    eureka.server.enableSelfPreservation=false
  