package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceDbTest {
    @Qualifier("userServiceDb")
    @Autowired
    private UserService userService;

    static User user = new User(0,"u","u", User.Role.USER, User.Status.CREATED);

    @Test
    @Order(1)
    void save(){
        User actual = userService.save(user);
        user.setId(actual.getId());
        Assertions.assertEquals(user, actual);
    }
}
