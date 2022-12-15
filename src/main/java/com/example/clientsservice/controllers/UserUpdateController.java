package com.example.clientsservice.controllers;

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

@Controller
public class UserUpdateController {
    @Autowired
    private UserService userService;

    @GetMapping("userUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user",user);
        model.addAttribute("role", User.Role.values());
        model.addAttribute("status", User.Status.values());
        return "userUpdate";
    }

    @PostMapping ("updateUserForm")
    public ModelAndView method(@ModelAttribute User user) {
        System.err.println(user);
        userService.save(user);
        return new ModelAndView("redirect:userUpdate",
                new ModelMap("id", user.getId()));
    }
}
