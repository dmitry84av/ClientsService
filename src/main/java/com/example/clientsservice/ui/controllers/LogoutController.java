package com.example.clientsservice.ui.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;

@Controller
public class LogoutController {
    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null)
            new SecurityContextLogoutHandler().logout(request, response,authentication);
        return "redirect:";
    }
}
