package org.roy.unsecureapp.controller;

import org.roy.unsecureapp.db.UserRepository;
import org.roy.unsecureapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {

    private UserRepository userRepository;

    @Autowired
    public PublicRestApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Available to all authenticated users
    @GetMapping("test1")
    public String test1() {
        return "API Test 1";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String test2() {
        return "Some report data";
    }

    // Availble to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users() {
        return userRepository.findAll();
    }

}
