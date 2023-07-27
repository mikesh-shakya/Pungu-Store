package com.pungu.Pungu.Store.Controllers;

import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Entities.User;
import com.pungu.Pungu.Store.Payload.UserDTO;
import com.pungu.Pungu.Store.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId, @RequestBody User user){
        UserDTO userDTO = userService.updateUser(userId, user);
        return ResponseEntity.ok(userDTO);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
