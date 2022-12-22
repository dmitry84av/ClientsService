package com.example.clientsservice.srvices.data.db;


import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositiries.AddressRepository;
import com.example.clientsservice.srvices.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AddressServiceDb implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }




}
