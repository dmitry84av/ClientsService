package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositiries.PhoneRepository;
import com.example.clientsservice.srvices.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceDb implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }
}
