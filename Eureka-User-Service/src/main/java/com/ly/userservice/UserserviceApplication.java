package com.ly.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ly.userservice.Client"})
public class UserserviceApplication {

//    @Autowired
//    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

//    /**
//     * 实例化RestTemplate
//     * @return
//     */
//    @LoadBalanced
//    @Bean
//    public RestTemplate rest() {
//        return new RestTemplate();
//    }
//
//    @GetMapping(value = "/getUser")
//    @ResponseBody
//    public String getUser(){
//        String data = restTemplate.getForObject("http://user-api/getUser/2",String.class);
//        return data;
//    }

}
