package com.ijse.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailsResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
