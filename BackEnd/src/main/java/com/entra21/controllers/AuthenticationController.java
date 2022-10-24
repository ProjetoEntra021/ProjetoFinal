package com.entra21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.entities.dto.ResponseDTO;
import com.entra21.entities.dto.UserDTO;
import com.entra21.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	public AuthenticationManager manager;
	
	@Autowired
	public UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user){
		manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		final String companyId = userRepository.findCompanyIdByUsername(user.getUsername()).toString();
		ResponseDTO response = new ResponseDTO();
		response.setSessionId(companyId);
		
		return ResponseEntity.ok(response);
	}
}
