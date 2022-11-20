package com.example.clientsservice.repositiries;

import com.example.clientsservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
