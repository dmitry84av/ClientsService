package com.example.clientsservice.controllers;
import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.PhoneService;
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
public class PhoneUpdateController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("phoneUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Phone phone = phoneService.findById(id);
        model.addAttribute("user",user);
        return "userUpdate";
    }

    @PostMapping("updateUserForm")
    public ModelAndView method(@ModelAttribute User user) {
        System.err.println(user);
        userService.save(user);
        return new ModelAndView("redirect:userUpdate",
                new ModelMap("id", user.getId()));
    }
}
