package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long>{

}
