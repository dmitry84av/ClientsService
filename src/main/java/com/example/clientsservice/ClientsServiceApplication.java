package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.repositiries.ClientRepository;
import com.example.clientsservice.repositiries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.example.clientsservice.models.Client.Gender.MALE;
@Configuration
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class ClientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsServiceApplication.class, args);
	}

	private final ClientRepository clientRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public ClientsServiceApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	//@EventListener(ApplicationReadyEvent.class)
	public void applicationReady(){
		Client a = new Client(0,"a","a","a",MALE,"a@test.com",
				null,null,null);
		Client b = new Client(0,"b","b","b",MALE,"b@test.com",
				null,null,null);
		clientRepository.saveAll(List.of(a, b));
		//users
		User admin = new User(0,"a","a",User.Role.ADMIN, User.Status.ACTIVE);
		User user = new User(0,"u","u",User.Role.USER, User.Status.ACTIVE);
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.saveAll(List.of(admin, user));
	}
}
