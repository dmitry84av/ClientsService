package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositiries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("registrationForm")
    public String regUser(@ModelAttribute User user) {
        user.setRole(User.Role.USER);
        user.setStatus(User.Status.CREATED);
        userRepository.save(user);
        return "redirect:authorization";
    }
}
