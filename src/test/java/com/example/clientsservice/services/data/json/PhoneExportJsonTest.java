package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.srvices.data.PhoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PhoneExportJsonTest {

    @Qualifier("phoneServiceJson")
    @Autowired
    private PhoneService phoneService;

    static Phone phone = new Phone(1,"hgjhj");

    @Test
    @Order(5)
    void save() {
        System.err.println(phoneService.findAll());
        Phone actual = phoneService.save(phone);
        phone.setId(actual.getId());
        Assertions.assertEquals(phone, actual);
    }
}
