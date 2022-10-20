package com.entra21.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	User findByUsername(String username);

}
