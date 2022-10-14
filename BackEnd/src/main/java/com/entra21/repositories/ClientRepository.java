package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entra21.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query(value = "select c from Client c where c.cpf = ?1")
	Client findByCpf(String cpf);

}
