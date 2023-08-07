package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Entities.User;
import com.pungu.Pungu.Store.Payload.AuthorBookList;
import com.pungu.Pungu.Store.Payload.UserAddressList;
import com.pungu.Pungu.Store.Payload.UserDTO;
import com.pungu.Pungu.Store.Repositories.UserRepository;
import com.pungu.Pungu.Store.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list.stream().map(this::converUserIntoUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Integer userId, User user) {
        User found_user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No such user exist."));

        found_user.setFirstname(user.getFirstname());
        found_user.setLastname(user.getLastname());
        found_user.setEmail(user.getEmail());
        found_user.setPassword(user.getPassword());

        userRepository.save(found_user);
        return converUserIntoUserDTO(found_user);
    }

    @Override
    public String deleteUser(Integer userId) {
        User found_user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No such user exist."));
        userRepository.delete(found_user);
        return "User deleted Successfully";
    }

    public UserDTO converUserIntoUserDTO(User u){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(u.getId());
        userDTO.setFirstname(u.getFirstname());
        userDTO.setLastname(u.getLastname());
        userDTO.setEmail(u.getEmail());
        userDTO.setPassword(u.getPassword());

        List<Address> addressList = u.getAddressList();
        List<UserAddressList> list = new ArrayList<>();

        for(Address address: addressList){
            UserAddressList userAddressList = new UserAddressList();

            userAddressList.setId(address.getId());
            userAddressList.setReceiverFirstname(address.getReceiverFirstname());
            userAddressList.setReceiverLastname(address.getReceiverLastname());
            userAddressList.setStreet(address.getStreet());
            userAddressList.setCity(address.getCity());
            userAddressList.setState(address.getState());
            userAddressList.setCountry(address.getCountry());
            userAddressList.setZipcode(address.getZipcode());


            list.add(userAddressList);
        }
        userDTO.setAddressList(list);

        return userDTO;
    }
}
