package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public String load(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("users",list);
        return "users";
    }
    @PostMapping("addUserForm")
    public String addUserForm(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") User.Role role,
            @RequestParam("status") User.Status status
    ) {
        User user = new User(0, username, password, role,status);
        userService.save(user);
        return "redirect:users";
    }
    @PostMapping("openUserForm")
    public ModelAndView openUserForm(@RequestParam("id") Integer id) {
        return new ModelAndView("redirect:userUpdate", new ModelMap("id", id));
    }
}
