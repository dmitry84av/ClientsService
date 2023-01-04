package com.example.clientsservice.services.datadb;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.AddressService;
import com.example.clientsservice.srvices.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashSet;
import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAddressServiceDbTest {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ClientService clientService;


    static Client a = new Client(0,"a","a","a",FEMALE,"a@test.com",
            null,null,null);
    static Client b = new Client(0,"b","b","b",MALE,"b@test.com",
            null,null,null);
    static Address ad1 = new Address(10,"dfg","dfg","dfg","dfg","dfg","dfg",a);
    static Address ad2 = new Address(20,"dfhgb","dhfgb","dfglb","dlfgb","dfgbs","dfgbs",b);
    @Test
    @Order(1)
    void save() {
        List<Client> clientList = clientService.saveAll(List.of(a,b));
        List<Address> addressList = addressService.saveAll(List.of(ad1,ad2));
        //
        clientList.forEach(client -> client.getAddress().addAll(addressList));
        //
        clientService.saveAll(clientList);
        addressService.saveAll(addressList);
    }
}

