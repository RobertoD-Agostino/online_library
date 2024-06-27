package com.example.library.online_library.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.online_library.dtos.ClientBuyedBooksDto;
import com.example.library.online_library.dtos.ClientDto;
import com.example.library.online_library.dtos.ClientRentedBooksDto;
import com.example.library.online_library.entities.Book;
import com.example.library.online_library.entities.BuyedBook;
import com.example.library.online_library.entities.Client;
import com.example.library.online_library.repositories.BookRepository;
import com.example.library.online_library.repositories.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AdminService {
	
	private final ClientRepository clientRepo;
	private final BookRepository bookRepo;
	
	public Client addClient(Client client)throws RuntimeException {
		return clientRepo.save(client);
	}
	
	public String removeClient(String email)throws RuntimeException {
		Client client = clientRepo.findByEmail(email).orElseThrow();
		clientRepo.delete(client);
		return "Utente eliminato";
	}
	
	
	public ClientDto findClientByEmail(String email)throws RuntimeException {
		Client client = clientRepo.findByEmail(email).orElseThrow();
		ClientDto ret = new ClientDto(client.getId(),client.getFullName(),client.getEmail(),client.getPassword()); 
		return ret;
	}
	
	public List<ClientDto> getAllClients()throws RuntimeException{
	    List<Client> lista = clientRepo.findAll();
	    List<ClientDto> ret = new ArrayList<>();
	    for (Client client : lista) {
			ClientDto clientRet = new ClientDto
					(
					client.getId(),
					client.getFullName(),
					client.getEmail(),
					client.getPassword()
					);
			if (!ret.contains(clientRet)) {
				ret.add(clientRet);
			}
		}
	    return ret;
	}
	
	public ClientBuyedBooksDto getClientBuyedBooks(String email){
		Client client = clientRepo.findByEmailWithBuyedBooks(email).orElseThrow();
		ClientBuyedBooksDto ret = new ClientBuyedBooksDto(client.getId(), client.getFullName(), client.getEmail(), client.getBuyedBooks());
		return ret;
	}

	public ClientRentedBooksDto getClientRentedBooks(String email){
		Client client = clientRepo.findByEmailWithRentedBooks(email).orElseThrow();
		ClientRentedBooksDto ret = new ClientRentedBooksDto(client.getId(), client.getFullName(), client.getEmail(), client.getRentedBooks());
		return ret;
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void deleteBook(int isbn) {
		Book book = bookRepo.findByIsbn(isbn).orElseThrow();
		bookRepo.delete(book);
	}
	
	public Book modifyBook(int isbn, String newTitle, String newAuthor, String newGender, int newYear,double newPrice, int newIsbn) {
		Book book = bookRepo.findByIsbn(isbn).orElseThrow();
		Book ret = new Book(
				book.getId(),
				book.getTitle(),
				book.getAuthor(),
				book.getGender(),
				book.getYear(),
				book.getPrice(),
				book.getIsbn()
				);
		return bookRepo.save(ret);	
	}
	
	public Book findBookByIsbn(int isbn) {
		return bookRepo.findByIsbn(isbn).orElseThrow();	
	}
}
