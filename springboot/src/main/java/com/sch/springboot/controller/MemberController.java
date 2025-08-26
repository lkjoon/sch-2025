package com.sch.springboot.controller;


import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member")
    public String spring(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         @RequestParam("address") String address,
                         Model model) { //파라메터를 받는 매개변수 자리
        System.out.println(name); // 서버콘솔에 출력
        System.out.println(age);
        System.out.println(address);

        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        member.setAddress(address);

        model.addAttribute("member", member);


        return  "member"; //View name
    }
}
