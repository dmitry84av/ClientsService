package com.example.clientsservice.ui.restcontrollers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/rest/addUserForm")
    public ResponseEntity<?> addUserForm(@RequestBody User user) {
        System.err.println(user);
        userService.save(user);
        List<User> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
