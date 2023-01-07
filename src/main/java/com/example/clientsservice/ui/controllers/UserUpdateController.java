package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserUpdateController {

    @Autowired
    private UserService userService;

    @GetMapping("userUpdate")
    public String load(@RequestParam("userId") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        Map<User.Role, String> roles = new HashMap<>();

    }
}
