package com.example.clientsservice.repositiries;

import com.example.clientsservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
