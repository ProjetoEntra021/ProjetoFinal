package com.entra21.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.entra21.entities.User;
import com.entra21.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User existsUser = userRepository.findByUsername(username);

		if (existsUser == null) {
			throw new Error("User does not exists!");
		}
		return UserPrincipal.create(existsUser);
	}

	public boolean Authenticate(String username, String password) {

		User existsUser = userRepository.findByUsername(username);

		if (existsUser == null) {
			throw new Error("User does not exists!");
		} else if (existsUser.getUsername() == username) {
			existsUser.setUsername(username);
			if (BCrypt.checkpw(password, existsUser.getPassword())) {
				// Enviar para o front junto do id e do username
				return true;
			} else {
				throw new Error("Password dont matches");

			}
		}
		return false;
	}
}
