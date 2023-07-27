package com.pungu.Pungu.Store.Repositories;

import com.pungu.Pungu.Store.Entities.Address;
import com.pungu.Pungu.Store.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    public List<Address> findByUser(User user);
}
