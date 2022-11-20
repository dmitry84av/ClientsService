package com.example.clientsservice.repositiries;

import com.example.clientsservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
