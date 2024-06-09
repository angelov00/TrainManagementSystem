package com.example.trainmanagementsystem.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
