package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpringController {

    @GetMapping("/spring")
    public String spring(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         Model model) {
        //model객체에 추가 --> view 전달
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "spring";  //view name
    }
}
