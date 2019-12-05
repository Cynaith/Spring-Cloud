package com.ly.imart.user.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;

@RestController
public class UserController {

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id") int id){
        return "返回"+id+2+2;
    }
}
