package com.example.library.online_library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.online_library.entities.Client;
import com.example.library.online_library.services.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    
    @PostMapping("/addClient")
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        try {
            Client ret = clientService.addClient(client);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName() + " l'utente " + client.getEmail() + " esiste già";
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
        }
    }
    
}
