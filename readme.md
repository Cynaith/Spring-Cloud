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

### Feign
* 包
    * Maven环境下:(消费者中添加依赖)
    ```xml
    <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-feign -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-feign</artifactId>
          <version>1.4.6.RELEASE</version>
      </dependency>

    ```
* 主要步骤
    ---
    步骤
    Demo
    注
    |-|-|-|
    |创建一个名为UserFeignClient接口|@FeignClient(name="user-api")<br>public interface UserFeignClient{<br>@RequestMapping(value="/getUser")<br>public String getUser(@RequestParam("id")int id);<br>}|注:@FeignClient("")注解中name值为微服务项目在EurekaServer中注册名称。<br>或与spring.application.name一致
    |创建一个类提供方法，通过接口调用Eureka提供者的方法|@RestController<br>public class UserController{<br>@Autowired<br>private UserFeignClient userFeignClient;<br>@RequestMapping("/getUser")<br>public String getUser(){<br>return userFeignClient.getUser(2);<br>}<br>}|
    |修改启动类|@RestController<br>@SpringBootApplication<br>@EnableEurekaClient<br>@EnableFeignClients<br>public class UserserviceApplication{<br>public static void main(String[] args){<br>SpringApplication.run(UserserviceApplication.class,args);<br>}<br>}|
    
    ---
    
### Hystrix
* 主要步骤
    ---
    步骤
    Demo
    注
    |-|-|-|
    |@FeignClient()加注解|@FeignClient(name="user-api",fallback=UserFeignClientFallBack.class)<br>public interface UserFeignClient{<br>@RequestMapping(value="/getUser")<br>public String getUser(@RequestParam("id")int id);<br>}|
    |创建容器处理类实现Feign接口|@Component<br>public class UserFeignClientFallBack implements UserFeignClient{<br>@Override<br>public String getUser(int id){<br>return "服务异常，请稍后重试";<br>}<br>}|
    |配置文件|feign:<br>hystrix:<br>enabled:true|
    
    ---
    

