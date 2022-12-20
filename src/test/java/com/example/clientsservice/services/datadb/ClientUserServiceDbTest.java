package com.example.clientsservice.services.datadb;


import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.ClientService;
import com.example.clientsservice.srvices.data.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientUserServiceDbTest {
    @Autowired
    UserService userService;

    @Autowired
    private ClientService clientService;


    static Client a = new Client(0,"a","a","a",FEMALE,"a@test.com",
            null,null,null);
    static Client b = new Client(0,"b","b","b",MALE,"b@test.com",
            null,null,null);
    static User ad1 = new User(20,"Gregor","Lobov", User.Role.USER, User.Status.BLOCKED);
    static User ad2 = new User(10,"Igor","Gobov", User.Role.ADMIN, User.Status.ACTIVE);
    @Test
    @Order(1)
    void save() {
        List<Client> clientList = clientService.saveAll(List.of(a,b));
        List<User> userList = userService.saveAll(List.of(ad1,ad2));
        //
        //
        clientService.saveAll(clientList);
        userService.saveAll(userList);
    }
}
