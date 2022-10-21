package com.entra21.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entra21.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	User findByUsername(String username);

	@Query("select u from User u where u.company.id = ?1")
	User findByCompanyId(Long companyId);
	
	@Query("select u.company.id from User u where u.username = ?1")
	Long findCompanyIdByUsername(String username);
}
