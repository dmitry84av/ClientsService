package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.User;

import java.util.List;

public interface UserService {
    static User save(User user) {
        return null;
    }

    List<User> saveAll(List<User> users);

    List<User> findAll();
}
