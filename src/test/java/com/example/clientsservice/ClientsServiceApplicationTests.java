package com.example.clientsservice;

import com.example.clientsservice.repositiries.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientsServiceApplicationTests {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	void contextLoads() {
		//Assertions.assertNull(clientRepository, "Not NULL!!!");
		Assertions.assertNull(clientRepository, () -> String.format("%s", 111) );
	}
}
