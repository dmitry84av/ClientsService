package com.example.clientsservice.srvices.data.json;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceJson implements UserService {
    @Override
    public List<User> saveAll(List<User> users) {
        return null;
    }
}
