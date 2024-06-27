package com.example.library.online_library.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
	private Integer id;
	private String fullName;
	private String email;
	private String password;
	
}
