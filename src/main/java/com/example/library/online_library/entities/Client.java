package com.example.library.online_library.entities;

import java.util.List;

import com.example.library.online_library.dtos.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@Table(name = "client")
public class Client extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fullName")
    private String fullName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "budget")
    private Double budget;

    @OneToMany(mappedBy = "client")
    private List<RentedBook> rentedBooks;

    @OneToMany(mappedBy = "client")
    private List<BuyedBook> buyedBooks;

    @OneToMany(mappedBy = "client")
    private List<RentalRequest> rentalRequests;
}