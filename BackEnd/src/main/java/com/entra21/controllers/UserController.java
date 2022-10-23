package com.entra21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.entities.User;
import com.entra21.services.CreateUserService;



@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  CreateUserService createUserService;

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return createUserService.execute(user);
  }

}
