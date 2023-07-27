package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.User;
import com.pungu.Pungu.Store.Payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public List<UserDTO> getAllUsers();
    public UserDTO updateUser(Integer userId, User User);
    public String deleteUser(Integer userId);
}
