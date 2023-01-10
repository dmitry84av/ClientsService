package com.example.clientsservice.repositiries;

import com.example.clientsservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAllByAmountEquals(int amount);
}
