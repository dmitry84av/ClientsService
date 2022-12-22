package com.example.clientsservice.controllers;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.srvices.data.ClientService;
import com.example.clientsservice.srvices.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PhoneService phoneService;

    @GetMapping("clientUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("genders",Client.Gender.values());
        return "clientUpdate";
    }
    @PostMapping("updateClientForm")
    public ModelAndView method(@ModelAttribute Client client){
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate", new ModelMap("id",client.getId()));
    }
    @PostMapping("updateClientPhoneForm")
    public ModelAndView updateClientPhoneForm(
            @ModelAttribute Client client,
            @ModelAttribute Phone phone,
            @RequestParam(value = "idPhone", required = false) Integer idPhone) {
        phone.setId(idPhone);
        phone = phoneService.save(phone);
        client.setPhones((Set<Phone>) phone);
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate", new ModelMap("id",client.getId()));
    }
}
