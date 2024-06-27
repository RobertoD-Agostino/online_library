package com.example.library.online_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.online_library.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
