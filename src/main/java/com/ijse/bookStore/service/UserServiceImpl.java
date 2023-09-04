package com.ijse.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.dto.UpdatePasswordDTO;
import com.ijse.bookStore.dto.UserDetailsResponseDTO;
import com.ijse.bookStore.entity.User;
import com.ijse.bookStore.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepository;

    @Override
    public List<UserDetailsResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDetailsResponseDTO> userDetails = new ArrayList<>();
        

        for (User user: users) {
            UserDetailsResponseDTO userDetail = new UserDetailsResponseDTO();
            userDetail.setId(user.getId());
            userDetail.setEmail(user.getEmail());
            userDetail.setFirstName(user.getFirstName());
            userDetail.setLastName(user.getLastName());
            userDetail.setPhone(user.getPhone());

            userDetails.add(userDetail);
        }
        return userDetails;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found: " + id));
    }

    @Override
    public UserDetailsResponseDTO updateUser(Long id, User user) {
        User existingUser = getUserById(id);

        if (user.getFirstName() != null){
            existingUser.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null){
            existingUser.setLastName(user.getLastName());
        }

        if (user.getEmail() != null){
            existingUser.setEmail(user.getEmail());
        }

        if (user.getPhone() != null){
            existingUser.setPhone(user.getPhone());
        }

        userRepository.save(existingUser);

        UserDetailsResponseDTO userDetailsResponseDTO = new UserDetailsResponseDTO();

        userDetailsResponseDTO.setId(existingUser.getId());
        userDetailsResponseDTO.setFirstName(existingUser.getFirstName());
        userDetailsResponseDTO.setLastName(existingUser.getLastName());
        userDetailsResponseDTO.setEmail(existingUser.getEmail());
        userDetailsResponseDTO.setPhone(existingUser.getPhone());

        return userDetailsResponseDTO;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetailsResponseDTO updatePassword(Long id, UpdatePasswordDTO updatePasswordDTO) {
        User existingUser = getUserById(id);
        if (updatePasswordDTO.getPassword() != null){
            existingUser.setPassword(updatePasswordDTO.getPassword());
        } else {
            throw new NoSuchElementException("Password cannot be null");
        }
        userRepository.save(existingUser);

        UserDetailsResponseDTO userDetailsResponseDTO = new UserDetailsResponseDTO();
        userDetailsResponseDTO.setId(existingUser.getId());
        userDetailsResponseDTO.setFirstName(existingUser.getFirstName());
        userDetailsResponseDTO.setLastName(existingUser.getLastName());
        userDetailsResponseDTO.setEmail(existingUser.getEmail());
        userDetailsResponseDTO.setPhone(existingUser.getPhone());

        return userDetailsResponseDTO;
    }
    
}
