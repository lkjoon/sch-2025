package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    @ResponseBody
    @PostMapping("/member-api")
    public Member memberApi(@ModelAttribute Member member) {
        return member;  //Rest API
    }


    @PostMapping("/member")
    public String member(@ModelAttribute Member member, Model model) {
        System.out.println("Post!!");
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/member")
    public String memer(@ModelAttribute Member member,
                        Model model) {

        model.addAttribute("member", member);

        return "member";  //view name + model 객체
    }
}
