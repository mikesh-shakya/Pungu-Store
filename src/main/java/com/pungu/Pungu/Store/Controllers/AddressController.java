package com.pungu.Pungu.Store.Controllers;

import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Entities.User;
import com.pungu.Pungu.Store.Payload.AddressDTO;
import com.pungu.Pungu.Store.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressDTO>> getAllAddressForUser(@PathVariable Integer userId){
        return ResponseEntity.ok(addressService.getAllAddressForUser(userId));
    }
    @PostMapping("/create/user/{userId}")
    public ResponseEntity<AddressDTO> addAddress(@PathVariable Integer userId, @RequestBody Address address){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(address, userId));
    }
    @PutMapping("/update/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Integer addressId, @RequestBody Address address){
        return ResponseEntity.ok(addressService.updateAddress(addressId, address));
    }
    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer addressId){
        return ResponseEntity.ok(addressService.deleteAddress(addressId));
    }
}
