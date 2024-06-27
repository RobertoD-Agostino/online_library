package com.example.library.online_library.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.online_library.dtos.ClientBuyedBooksDto;
import com.example.library.online_library.dtos.ClientDto;
import com.example.library.online_library.dtos.ClientRentedBooksDto;
import com.example.library.online_library.entities.Book;
import com.example.library.online_library.entities.Client;
import com.example.library.online_library.services.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminService adminService;

    @PostMapping("/addClient")
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        try {
            Client ret = adminService.addClient(client);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName() + " l'utente " + client.getEmail() + " esiste già";
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @DeleteMapping("/removeClient")
    public ResponseEntity<?> removeClient(@RequestParam("email") String email){
    	try {
    		String ret = adminService.removeClient(email);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/findByEmail")
    public ResponseEntity<?> findClientByEmail(@RequestParam("email") String email){
    	try {
    		ClientDto ret = adminService.findClientByEmail(email);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/getAllClients")
    public ResponseEntity<?> getAllClients(){
    	try {
    		List<ClientDto> ret = adminService.getAllClients();
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/getBuyedBooks")
    public ResponseEntity<?> getClientBuyedBooks(@RequestParam("email") String email){
    	try {
    		ClientBuyedBooksDto ret = adminService.getClientBuyedBooks(email);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/getRentedBooks")
    public ResponseEntity<?> getClientRentedBooks(@RequestParam("email") String email){
    	try {
    		ClientRentedBooksDto ret = adminService.getClientRentedBooks(email);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book){
    	try {
    		Book ret = adminService.addBook(book);
    		return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/removeBook")
    public ResponseEntity<?> removeBook(@RequestParam("isbn") int isbn){
    	try {	
    		adminService.deleteBook(isbn);
    		return new ResponseEntity<>("Libro eliminato", HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @PutMapping("/modifyBook")
    public ResponseEntity<?> modifyBook(@RequestParam("isbn") int isbn, @RequestParam("title") String newTitle,@RequestParam("author") String newAuthor, @RequestParam("gender")String newGender, @RequestParam("year") int newYear, @RequestParam("price") double newPrice, @RequestParam("newIsbn") int newIsbn){
    	try {
			Book ret = adminService.modifyBook(isbn, newTitle, newAuthor, newGender, newYear, newPrice, newIsbn);
    		return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/findBook")
    public ResponseEntity<?> findBookByIsbn(@RequestParam("isbn") int isbn){
    	try {
    		Book ret = adminService.findBookByIsbn(isbn);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
            String errore = "Errore: " + e.getClass().getSimpleName();
            return new ResponseEntity<>(errore, HttpStatus.BAD_REQUEST);
		}
    }
}
