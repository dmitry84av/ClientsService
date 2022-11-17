package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Client;

import java.util.Collection;
import java.util.List;

public interface ClientService {
    Client save(Client client);

    List<Client> findAll();

    List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    void deleteAll();

    Client findById(Integer id);
}
