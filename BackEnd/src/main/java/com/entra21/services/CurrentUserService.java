package com.entra21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entra21.entities.CurrentUser;
import com.entra21.entities.User;
import com.entra21.repositories.UserRepository;

@Service
public class CurrentUserService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = repository.findByUsername(username);
		
		if (user != null) {
			CurrentUser currentUser = new CurrentUser();
			currentUser.setUsername(user.getUsername());
			currentUser.setPassword(user.getPassword());
			
			return currentUser;
		}
		
		throw new UsernameNotFoundException("Failed to find user with username: " + username);
	}

}
