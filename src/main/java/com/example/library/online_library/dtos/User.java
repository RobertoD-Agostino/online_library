package com.example.library.online_library.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.MappedSuperclass;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String fullName;
    private String email;
    private String password;
}
