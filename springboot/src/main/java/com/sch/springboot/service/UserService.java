package com.sch.springboot.service;

import com.sch.springboot.dto.User;
import com.sch.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * login : 로그인 비즈니스 로직 처리
     */
    public Map<String, Object> login(User user) {
        System.out.println("UserService login ---> ");
        System.out.println(user.getId() + "," + user.getPass());
        return userRepository.login(user);  //Map<String, Object>
    }

    /**
     * signUp : 회원가입 비즈니스 로직 처리
     */
    public Map<String, String> signUp(User user) {
        return userRepository.signUp(user);
    }
}
