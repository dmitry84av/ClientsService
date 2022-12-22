package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositiries.PhoneRepository;
import com.example.clientsservice.srvices.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceDb implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return null;
    }

    @Override
    public List<Phone> findAll() { return phoneRepository.findAll();
    }
}
