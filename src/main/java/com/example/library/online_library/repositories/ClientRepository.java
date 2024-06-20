package com.example.library.online_library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.online_library.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByEmail(String email);
}
