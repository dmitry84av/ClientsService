package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.repositiries.AddressRepository;
import com.example.clientsservice.srvices.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDb implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> saveAll(List<Address> addresses) {
        return addressRepository.saveAll(addresses);
    }
}
