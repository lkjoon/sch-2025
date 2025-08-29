package com.sch.springboot.controller;

import com.sch.springboot.dto.User;
import com.sch.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

//    UserService userService = new UserService();   //강한 결합(Tight Coupling)
    UserService userService;

    //생성자를 통해 느슨한 결합(Loose Coupling)
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //setter 메소드를 통해 느슨한 결합(Loose Coupling)
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


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
