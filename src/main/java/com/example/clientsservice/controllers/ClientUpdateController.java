package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Client.Gender;
import com.example.clientsservice.srvices.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;
    @GetMapping ("clientUpdate")
    public String load(@RequestParam("clientId") Integer id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        for (Gender value: Gender.values()){
              model.addAttribute(value.name(), value==client.getGender()? "selected" : "");
        }
        return "clientUpdate";
    }
}
