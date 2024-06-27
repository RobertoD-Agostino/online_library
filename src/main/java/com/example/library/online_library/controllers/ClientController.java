package com.example.library.online_library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.online_library.entities.Client;
import com.example.library.online_library.services.ClientService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    
    @PutMapping("/modifyClient")   
    public ResponseEntity<?> modifyUser(@RequestParam("email") String email,@RequestParam("newFullName") String newFullName, @RequestParam("newEmail") String newEmail, @RequestParam("newPassword") String newPassword, @RequestParam("newBudget") Double newBudget){
        try {
           Client ret =  clientService.modifyClient(email, newFullName, newEmail, newPassword, newBudget);
            return new ResponseEntity<>(ret, HttpStatus.OK);
         } catch (Exception e) {
            String errore = "Errore: "+ e.getClass().getSimpleName() +" impossibile modificare l'utente " + email;
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
         }

    }
    
}
