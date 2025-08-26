package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//레스트컨트롤러 가 있으면 @ResponseBody 생략 가능
@RestController
public class SpringRestController {
    @GetMapping("/spring-api")
    public Member springApi() {
        Member member = new Member();

        member.setName("홍길동");
        member.setAge(30);
        member.setAddress("춘천시");
        member.setSubject("스프링 부트");

        return member;
    }
}
