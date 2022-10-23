package com.entra21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entra21.entities.User;
import com.entra21.repositories.UserRepository;



@Service
public class CreateUserService {

  @Autowired
  UserRepository userRepository;

  
  private BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
  }
  
  
  public User execute(User user) {

    User existsUser = userRepository.findByUsername(user.getUsername());

    if (existsUser != null) {
      throw new Error("User already exists!");
    }

    user.setPassword(passwordEncoder().encode(user.getPassword()));
    
    User createdUser = userRepository.save(user);

    return createdUser;
  }

}