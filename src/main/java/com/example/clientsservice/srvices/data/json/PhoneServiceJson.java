package com.example.clientsservice.srvices.data.json;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.srvices.data.PhoneService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceJson implements PhoneService {
    private final String phoneFiles = "phone.json";
    @Override
    public List<Phone> findAll() {
        try {
            List<Phone> list = new Gson().fromJson(new FileReader(phoneFiles),
                    new TypeToken<>() {
                    });
            if (list != null)
                return list;
        }
        catch(Exception ignored) {
        }
        return new ArrayList<>();
    }

    @Override
    public Phone save(Phone phone) {
        List<Phone> list = findAll();
        list.add(phone);
        saveAll((Phone) list);
        return phone;
    }

    private Phone saveAll(Phone phone) {
        try {
            //FileWriter writer = new FileWriter(phoneFiles);
            //new Gson().toJson(phone.writer);
            //writer.flush();
        }
        catch(Exception ignored) {
        }
        return phone;
    }
}
