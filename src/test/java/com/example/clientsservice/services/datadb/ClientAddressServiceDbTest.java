package com.example.clientsservice.services.datadb;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.AccountService;
import com.example.clientsservice.srvices.data.AddressService;
import com.example.clientsservice.srvices.data.ClientService;
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
public class ClientAddressServiceDbTest {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ClientService clientService;


    static Client a = new Client(0,"a","a","a",FEMALE,"a@test.com",
            null,null,null);
    static Address ac1 = new Address(0,"erertr7876",null);
    static Address ac2 = new Address(0,"erterttrr76786",null);
    @Test
    @Order(1)
    void save() {
        a = clientService.save(a);
        //
        ac1.setClient(a);
        ac2.setClient(a);

        ac1=AddressService.save(ac1);
        ac2=AddressService.save(ac2);
    }
    @Test
    @Order(2)
    @Transactional
    void findByClientId(){
        Client actual = clientService.findById(a.getId());
        System.out.println(actual);
        System.out.println(actual.getAddress());
    }
}
