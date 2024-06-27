package com.example.library.online_library.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "gender")
    private String gender;
    @Column(name = "year")
    private int year;
    @Column(name = "price")
    private double price;
    @Column(name = "isbn", nullable = false, unique = true)
    private int isbn;
}
