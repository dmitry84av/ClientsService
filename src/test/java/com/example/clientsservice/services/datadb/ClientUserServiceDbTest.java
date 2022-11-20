package com.example.clientsservice.services.datadb;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.srvices.data.AddressService;
import com.example.clientsservice.srvices.data.ClientService;
import com.example.clientsservice.srvices.data.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
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
    static User u1 = new User(0,"erertr7876",null);
    static User u2 = new User(0,"erterttrr76786",null);
    @Test
    @Order(1)
    void save() {
        a = clientService.save(a);
        //
        u1.setClient(a);
        u2.setClient(a);

        u1= UserService.save(u1);
        u2=UserService.save(u2);
    }
    @Test
    @Order(2)
    @Transactional
    void findByClientId(){
        Client actual = clientService.findById(a.getId());
        System.out.println(actual);
        System.out.println(actual.getUsers());
    }
}
