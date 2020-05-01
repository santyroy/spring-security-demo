package org.roy.unsecureapp.controller;

import org.roy.unsecureapp.db.UserRepository;
import org.roy.unsecureapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {

    private UserRepository userRepository;

    @Autowired
    public PublicRestApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PublicRestApiController() {
    }

    @GetMapping("test1")
    public String test1() {
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2() {
        return "API Test 2";
    }

    @GetMapping("users")
    public List<User> users() {
        return userRepository.findAll();
    }

}
