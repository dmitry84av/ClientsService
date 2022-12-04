package com.example.clientsservice.srvices.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.repositiries.AccountRepository;
import com.example.clientsservice.srvices.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> saveAll(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }
}
