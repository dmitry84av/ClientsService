package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositiries.UserRepository;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDb implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
