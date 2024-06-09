package com.example.trainmanagementsystem.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 6, max = 64)
    private String password;
}
