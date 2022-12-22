package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;

import java.util.List;

public interface AddressService {

    List<Address> saveAll(List<Address> address);

    Address save(Address address);
}
