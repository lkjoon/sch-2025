package com.sch.springboot.controller;

import com.sch.springboot.dto.User;
import com.sch.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    UserService userService = new UserService();

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(User user){

        return userService.login(user);  //Map<String, Object>
    }


    @ResponseBody
    @PostMapping("/signup")
    public Map<String, String> signup(User user){

        return userService.signUp(user);
    }
}
