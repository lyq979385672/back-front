package com.lyq.controller;


import com.lyq.bean.Result;
import com.lyq.bean.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;
import java.util.Objects;

@RestController

public class UserController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@Valid @RequestBody User user) {

        String username = user.getUsername();
       String password = user.getPassword();
       Result result = new Result();

       if(username.equals("") || (password.equals(""))){
           result.setCode(400);
           result.setMessage("用户名或者密码不能为空！");
           return result;
        }else {
           if ((username.equals("admin")) && (password.equals("123456"))) {
               result.setCode(200);
               System.out.println(result.getCode());
               return result;
           } else {
               result.setCode(400);
               System.out.println(result.getCode());
               return result;
           }
       }
    }
}
