package com.example.library.online_library.services;

import org.springframework.stereotype.Service;

import com.example.library.online_library.entities.Client;
import com.example.library.online_library.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {	
	
	private final ClientRepository clientRepo;
	
	public Client modifyClient(String email, String newFullName, String newEmail, String newPassword, Double newBudget)throws RuntimeException {
		Client client = clientRepo.findByEmail(email).orElseThrow();
		if (client!=null) {
			client.setFullName(newFullName);
			client.setEmail(newEmail);
			client.setPassword(newPassword);
			client.setBudget(newBudget);
			return clientRepo.save(client);
		}else {
			throw new RuntimeException();
		}

	}
}
