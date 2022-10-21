package com.entra21.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.entra21.entities.CurrentUser;
import com.entra21.repositories.UserRepository;
import com.entra21.services.CurrentUserService;

@Component
public class SessionFilter extends OncePerRequestFilter{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CurrentUserService currentUserService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain) throws ServletException, IOException {
		
		final String companyId = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(companyId == null || companyId.length() == 0) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String username = userRepository.findByCompanyId(Long.parseLong(companyId)).getUsername();
		System.out.println(username);
		if(username == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		CurrentUser currentUser = currentUserService.loadUserByUsername(username);
		
		final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				currentUser,
				null,
				currentUser.getAuthorities());
		
		auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(auth);
		filterChain.doFilter(request, response);
	}

}
