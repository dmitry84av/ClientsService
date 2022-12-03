package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.ClientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
@Order(101)
@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientExportJsonTest {

    @Qualifier("clientServiceJson")
    @Autowired
    private ClientService clientService;

    static Client client = new Client(1,"Dmitry","Tverdohleb","Igorevich", Client.Gender.MALE,"gjgyrytr");

    @Test
    @Order(4)
    void save() {
        System.err.println(clientService.findAll());
        Client actual = clientService.save(client);
        client.setId(actual.getId());
        Assertions.assertEquals(client, actual);
    }
}
