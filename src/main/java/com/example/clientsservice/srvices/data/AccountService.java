package com.example.clientsservice.srvices.data;

import com.example.clientsservice.models.Account;

import java.util.List;

public interface AccountService {
    static Account save(Account account) {
        return null;
    }

    List<Account> saveAll(List<Account> accounts);

    List<Account> findAllByAmountEquals(int amount);
}
