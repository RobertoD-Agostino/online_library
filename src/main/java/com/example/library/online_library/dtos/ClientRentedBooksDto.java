package com.example.library.online_library.dtos;

import java.util.List;

import com.example.library.online_library.entities.RentedBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRentedBooksDto {
	private Integer id;
	private String fullName;
	private String email;
	private List<RentedBook> rentedBooks;
	
}
