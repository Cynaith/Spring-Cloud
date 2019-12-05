## Spring-Cloud
### Eureka
* 包
    * Maven环境下:
    ```xml
    <!--https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-server-->
    <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
* 配置文件
    * SpringBoot环境下:
    ---
    key:
    value:
    含义:
    注:
    |:-: | :-: | :-: | :-:| 
    |eureka:instance:hostname|127.0.0.1|服务注册中心IP地址|
    |eureka:client:registerWithEureka|false|是否向服务注册中心注册自己|
    |eureka:client:fetchRegistry|false|是否检索服务|
    |eureka:client:serviceUrl|defaultZone:<br>http://${eureka.instance.hostname}:<br>${server.port}/eureka/|服务注册中心的配置内容，指定服务注册中心的位置|
    ---
* 主要注解
---
注解:
含义:
注:
 |:-: | :-: | :-:|
|@EnableEurekaServer|启用Eureka服务端|
|@EnableEurekaClient|如注册中心为Eureka,则推荐|
|@EnableDiscoveryClient|注解中含有@EnableEurekaClient功能|

---
