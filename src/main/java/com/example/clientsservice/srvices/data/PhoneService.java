package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.models.User;

import java.util.List;

public interface PhoneService {
    Phone save(Phone phone);

    List<Phone> findAll();

    Phone findById(Integer id);
}
