package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();

    Phone save(Phone phone);
}
