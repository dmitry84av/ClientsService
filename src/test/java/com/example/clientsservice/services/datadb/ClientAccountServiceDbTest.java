/*package com.example.clientsservice.services.datadb;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.AccountService;
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
public class ClientAccountServiceDbTest {
    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    static Client a = new Client(0,"a","a","a",FEMALE,"a@test.com",
            null,null,null);
    static Client b = new Client(0,"b","b","b",MALE,"b@test.com",
            null,null,null);
    static Account a1 = new Account(0L,10,new HashSet<>());
    static Account a2 = new Account(0L,20,new HashSet<>());
    @Test
    @Order(1)
    void save() {
        List<Client> clientList = clientService.saveAll(List.of(a,b));
        List<Account> accountList = accountService.saveAll(List.of(a1,a2));
        //
        clientList.forEach(client -> client.getAccounts().addAll(accountList));
        //
        clientService.saveAll(clientList);
        accountService.saveAll(accountList);
    }
}*/
