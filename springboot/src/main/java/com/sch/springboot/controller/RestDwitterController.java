package com.sch.springboot.controller;

import com.sch.springboot.dto.Dwitter;
import com.sch.springboot.service.DwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class RestDwitterController {

    private final DwitterService dwitterService;

    @Autowired
    public RestDwitterController(DwitterService dwitterService) {
        this.dwitterService = dwitterService;
    }


    /**
     * 리스트 조회
     */
    @GetMapping("/dwitters")
    public List<Dwitter> list(Model model) {
//        List<Dwitter> dwitters = dwitterService.findDwitters();
        return dwitterService.findDwitters();
    }

    /**
     * 등록
     */
    @PostMapping("/dwitters/register")
    public String register(@RequestBody Dwitter dwitter) {
        System.out.println(dwitter.getImage());
        return dwitterService.register(dwitter);
    }

    /**
     * 삭제
     */
    @PostMapping("/dwitters/delete")
    public String delete(@RequestBody Dwitter dwitter) {
//        System.out.println("id--->" +  dwitter.getId());
        return dwitterService.delete(Long.valueOf(dwitter.getId()));
    }
}
