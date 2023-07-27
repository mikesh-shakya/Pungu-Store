package com.pungu.Pungu.Store.Services.ServiceImpls;

import com.pungu.Pungu.Store.CustomException.ResourceNotFoundException;
import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Entities.User;
import com.pungu.Pungu.Store.Payload.AddressDTO;
import com.pungu.Pungu.Store.Repositories.AddressRepository;
import com.pungu.Pungu.Store.Repositories.UserRepository;
import com.pungu.Pungu.Store.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public AddressDTO addAddress(Address address, Integer userId) {
        User found_user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No such user exist"));
        address.setUser(found_user);
        return convertAddressToDTO(addressRepository.save(address));
    }

    @Override
    public List<AddressDTO> getAllAddressForUser(Integer userId) {
        User found_user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("No such user exist"));
        return addressRepository.findByUser(found_user).stream().map(this::convertAddressToDTO).collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(Integer addressId, Address address) {
        Address found_address = addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("No such Address id presents"));

        found_address.setReceiverFirstname(address.getReceiverFirstname());
        found_address.setReceiverLastname(address.getReceiverLastname());
        found_address.setStreet(address.getStreet());
        found_address.setCity(address.getCity());
        found_address.setState(address.getState());
        found_address.setCountry(address.getCountry());
        return convertAddressToDTO(addressRepository.save(found_address));
    }

    @Override
    public String deleteAddress(Integer addressId) {
        Address found_address = addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("No such Address id presents"));
        addressRepository.delete(found_address);
        return "The address has been deleted successfully.";
    }


    public AddressDTO convertAddressToDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setReceiverFirstname(address.getReceiverFirstname());
        addressDTO.setReceiverLastname(address.getReceiverLastname());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setUserId(address.getUser().getId());
        addressDTO.setUserName(address.getUser().getFirstname() + " " + address.getUser().getLastname());
        return addressDTO;
    }
}
