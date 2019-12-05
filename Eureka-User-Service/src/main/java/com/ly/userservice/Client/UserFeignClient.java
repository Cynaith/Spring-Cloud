package com.ly.userservice.Client;


import com.ly.userservice.Hystrix.UserFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zuul",fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user-api/getUser")
    public String getUser(@RequestParam("id") int id);
}
