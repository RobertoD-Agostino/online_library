package com.example.library.online_library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.online_library.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query("SELECT c FROM Client c WHERE c.email = :email")
    Optional<Client> findByEmail(@Param("email") String email);
	
	@Query("SELECT c FROM Client c LEFT JOIN FETCH c.buyedBooks WHERE c.email = :email")
	Optional<Client> findByEmailWithBuyedBooks(@Param("email") String email);
	
	@Query("SELECT c FROM Client c LEFT JOIN FETCH c.rentedBooks WHERE c.email = :email")
	Optional<Client> findByEmailWithRentedBooks(@Param("email") String email);
}
