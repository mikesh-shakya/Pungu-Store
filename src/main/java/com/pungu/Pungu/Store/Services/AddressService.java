package com.pungu.Pungu.Store.Services;

import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Payload.AddressDTO;

import java.util.List;

public interface AddressService {

    public AddressDTO addAddress(Address address, Integer userId);
    public List<AddressDTO> getAllAddressForUser(Integer userId);
    public AddressDTO updateAddress(Integer addressId, Address address);
    public String deleteAddress(Integer addressId);
}
