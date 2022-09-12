package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
