package com.sch.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

@Controller
public class HelloController {

    @GetMapping("/spring-mvc")
    public String springMvc(Model model){
        model.addAttribute("msg", "홍길동 친구");
        return  "spring-mvc";//view 이름  templates에 파일 있어야함
    }

    @GetMapping("/hello")
    public String hello(Model model){
        //hello.html view 에게 데이터 전달 -- ModelAmdView   -> Model
        model.addAttribute("msg", "홍길동");

        return  "hello";//view 이름
    }
}


