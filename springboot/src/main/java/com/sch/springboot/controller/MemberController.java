package com.sch.springboot.controller;


import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    @GetMapping("/member")
    public String member(@ModelAttribute Member member,  //form.html 이름과 Member 겟터 셋터 멤버변수 이름이 모두 같아야함
                         Model model) { //파라메터를 받는 매개변수 자리

        model.addAttribute("member", member);


        return  "member"; //View name
    }


    @PostMapping("/member")
    public String submit(@ModelAttribute Member member, Model model) {

        System.out.println("Post!!");
        model.addAttribute("member", member);
        return "member";
    }

    @ResponseBody
    @PostMapping("/member-api")
    public Member submit(@ModelAttribute Member member) {
        return member;
    }
}
