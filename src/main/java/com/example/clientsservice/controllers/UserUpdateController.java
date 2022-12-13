package com.example.clientsservice.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserUpdateController {
    @Qualifier("userServiceDb")
    @Autowired
    private UserService userService;

    @GetMapping("userUpdate")
    public String load(@RequestParam("userId") Integer id , Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        Object role = new Object(){
            String USER = "";
            String ADMON = "selected";
        };
        model.addAttribute("role", role);
        return "userUpdate";
    }
}
