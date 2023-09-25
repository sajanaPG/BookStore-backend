package com.ijse.bookStore.dto;

import com.ijse.bookStore.entity.Role;

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
    private Role role;
}
