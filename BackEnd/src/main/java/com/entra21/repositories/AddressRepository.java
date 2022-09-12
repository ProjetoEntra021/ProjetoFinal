package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
