package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;

import java.util.List;

public interface AddressService {
    static Address save(Address address) {
        return null;
    }

    List<Account> saveAll(List<Account> addresses);
}
