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

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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
    static User ad1 = new User(0L,10,new HashSet<>());
    static User ad2 = new User(0L,20,new HashSet<>());
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
