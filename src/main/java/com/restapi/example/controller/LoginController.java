package com.restapi.example.controller;

import com.restapi.example.entity.Role;
import com.restapi.example.entity.User;
import com.restapi.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Shows registration form
     *
     * @return view representation
     */
    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    /**
     * Signs up new user
     *
     * @param user User object
     * @return view representation
     */
    @PostMapping("/registration")
    public String addUser(User user) {
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
