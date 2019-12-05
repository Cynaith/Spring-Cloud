package com.ly.userservice.Controller;

import com.ly.userservice.Client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;

@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/getUser" )
    public String getUser(){
        System.out.println("请求转发");
        return userFeignClient.getUser(2);
    }
}
