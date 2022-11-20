package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.repositiries.UserRepository;
import com.example.clientsservice.srvices.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDb implements UserService {
    @Autowired
    private UserRepository userRepository;
}
