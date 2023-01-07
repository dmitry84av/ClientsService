package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        for (User.Role value: User.Role.values()) {
            roles.put(value, value == user.getRole() ? "selected" : "");
        }
        model.addAttribute("roles", roles.entrySet());
        Map<User.Status, String> status = new HashMap<>();
        for (User.Status value: User.Status.values()) {
            status.put(value, value == user.getStatus() ? "selected" : "");
        }
        model.addAttribute("status", status.entrySet());
        return "userUpdate";
    }
    @PostMapping("userUpdateForm")
    public ModelAndView userUpdateForm(@ModelAttribute("user") User user) {
        userService.save(user);
        return new ModelAndView("redirect:userUpdate",
                new ModelMap("userId", user.getId()));
    }
}
