package com.example.clientsservice.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public String load(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("users", list);
        model.addAttribute("role", User.Role.values());
        model.addAttribute("status", User.Status.values());
        return "users";
    }
    @PostMapping("addUserForm")
    public String addUserForm(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:users";
    }
}
