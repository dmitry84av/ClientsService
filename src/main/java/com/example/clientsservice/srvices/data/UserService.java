package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    List<User> saveAll(List<User> users);
}
