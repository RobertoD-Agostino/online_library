package com.example.library.online_library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.online_library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	Optional<Book> findByIsbn(int isbn);
}
