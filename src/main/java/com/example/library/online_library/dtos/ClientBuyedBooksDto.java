package com.example.library.online_library.dtos;

import java.util.List;

import com.example.library.online_library.entities.BuyedBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientBuyedBooksDto {
	private Integer id;
	private String fullName;
	private String email;
	private List<BuyedBook> buyedBooks;
	
}
