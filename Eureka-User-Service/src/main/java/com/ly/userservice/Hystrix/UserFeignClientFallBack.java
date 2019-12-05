package com.ly.userservice.Hystrix;

import com.ly.userservice.Client.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements UserFeignClient {
    @Override
    public String getUser(int id) {
        return "服务异常，请稍后重试";
    }
}
