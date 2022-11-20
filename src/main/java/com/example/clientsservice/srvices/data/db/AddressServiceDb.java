package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.repositiries.AddressRepository;
import com.example.clientsservice.srvices.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceDb implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
}
