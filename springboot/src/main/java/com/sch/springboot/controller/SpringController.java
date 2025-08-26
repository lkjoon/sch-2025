package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @ResponseBody  //View를 거치지 않고 문자혈 형태로 바로 전송
    @GetMapping("/spring-api")
    public String springApi(@ModelAttribute Member member) {

        return member.toString();
    }


    @GetMapping("/spring")
    public String spring(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         Model model) { //파라메터를 받는 매개변수 자리
        System.out.println(name); // 서버콘솔에 출력
        System.out.println(age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return  "spring"; //View name
    }

}
