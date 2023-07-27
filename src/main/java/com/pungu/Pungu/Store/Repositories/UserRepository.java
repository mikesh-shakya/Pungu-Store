package com.pungu.Pungu.Store.Repositories;

import com.pungu.Pungu.Store.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
