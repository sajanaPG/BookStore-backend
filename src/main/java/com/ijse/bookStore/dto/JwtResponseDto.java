package com.ijse.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponseDto {
    private String token;
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
