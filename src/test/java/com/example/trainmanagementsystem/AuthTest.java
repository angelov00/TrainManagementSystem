package com.example.trainmanagementsystem;

import com.example.trainmanagementsystem.model.DTO.UserRegisterDTO;
import com.example.trainmanagementsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AuthTest {

    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @Test
    void shouldNotRegisterAlreadyTakenEmail() {
        UserRegisterDTO existing = new UserRegisterDTO();
        existing.setFirstName("Ivan");
        existing.setLastName("Ivanov");
        existing.setEmail("1234567");
        existing.setPhoneNumber("08785858585");
        existing.setPassword("test123");

        this.userService.register(existing);

        ResponseEntity<String> response = restTemplate
                .postForEntity("/auth/register", existing, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldRegister() {
        UserRegisterDTO toRegister = new UserRegisterDTO();
        toRegister.setFirstName("James");
        toRegister.setLastName("Gosling");
        toRegister.setEmail("james@gmail.com");
        toRegister.setPhoneNumber("087111000");
        toRegister.setPassword("java");

        ResponseEntity<String> response = restTemplate
                .postForEntity("/auth/register", toRegister, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}
