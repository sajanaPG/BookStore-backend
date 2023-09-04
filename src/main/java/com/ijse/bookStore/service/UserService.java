package com.ijse.bookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.bookStore.dto.UpdatePasswordDTO;
import com.ijse.bookStore.dto.UserDetailsResponseDTO;
import com.ijse.bookStore.entity.User;

@Service
public interface UserService {
    List<UserDetailsResponseDTO> getAllUsers(); 
    User getUserById(Long id);
    UserDetailsResponseDTO updateUser(Long id, User user);
    UserDetailsResponseDTO updatePassword(Long id, UpdatePasswordDTO updatePasswordDTO);
    void deleteUser(Long id);
}
