package com.example.library.online_library.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "client")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fullName")
    private String fullName;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "budget")
    private Double budget;

    @OneToMany
    @JoinColumn(name = "rented_book_list")
    @JsonIgnore
    private List<RentedBook> rentedBooks;

    @OneToMany
    @JoinColumn(name = "buyed_book_list")
    @JsonIgnore
    private List<BuyedBook> buyedBooks;

    @OneToMany
    @JoinColumn(name = "rental_request_list")
    @JsonIgnore
    private List<RentalRequest> rentalRequests;
}