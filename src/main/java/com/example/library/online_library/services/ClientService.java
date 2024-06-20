package com.example.library.online_library.services;

import org.springframework.stereotype.Service;

import com.example.library.online_library.entities.Client;
import com.example.library.online_library.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {	
	
	private final ClientRepository clientRepo;
	
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}
}
