package com.sch.springboot.controller;


import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member")
    public String spring(@ModelAttribute Member member,  //form.html 이름과 Member 겟터 셋터 멤버변수 이름이 모두 같아야함
                         Model model) { //파라메터를 받는 매개변수 자리

        model.addAttribute("member", member);


        return  "member"; //View name
    }
}
