package com.ijse.bookStore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookStore.dto.MessageResponseDTO;
import com.ijse.bookStore.dto.UpdatePasswordDTO;
import com.ijse.bookStore.dto.UserDetailsResponseDTO;
import com.ijse.bookStore.entity.User;
import com.ijse.bookStore.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService; 

    @GetMapping
    public ResponseEntity<List<UserDetailsResponseDTO>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("User not found: " + id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        try{
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("User not found: " + id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordDTO updatePasswordDTO){
        try{
            return ResponseEntity.ok(userService.updatePassword(id, updatePasswordDTO));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("User not found: " + id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok(new MessageResponseDTO("User deleted successfully"));
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("User not found: " + id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: " + e.getMessage()));
        }
    }


    
}
